import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as ol from 'openlayers';

const API_END_POINT = 'https://localhost:8765/observatory/api/';

@Component({
  selector: 'map-root',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  map: ol.Map;
  vectorLayer: ol.layer.Vector;
  vectorSource: ol.source.Vector;


  form_name: string = "";
  form_value: string = "";

  display_name:string='';
  display_value:string='';

  form_left:number;
  form_top:number;
  
  constructor(private httmp: HttpClient) {

  }

  ngOnInit() {

    this.vectorSource = new ol.source.Vector();
    this.vectorLayer = new ol.layer.Vector({
      source: this.vectorSource
    });

    this.map = new ol.Map({
      target: "map",
      layers: [
        new ol.layer.Tile({ source: new ol.source.OSM() }),
        this.vectorLayer
      ],
      view: new ol.View({
        center: ol.proj.fromLonLat([23, 38]),
        zoom: 7
      })
    });

    this.map.on('pointermove', (evt: any) => {
        let found = false;
        this.map.forEachFeatureAtPixel(evt.pixel,(feature=>{
          let p = feature.getProperties();
          this.display_name = p.name;
          this.display_value = p.value;
          this.form_left = evt.pixel[0] +10;
          this.form_top = evt.pixel[1]+10;
          found = true;
        }))
        if(!found){
          this.form_left = -9999;
        }
    })

    this.getMyPois();

  }

  getMyPois() {

    this.httmp.get(API_END_POINT)
      .toPromise()
      .then((d: { x: number, y: number, name: string, value: string }[]) => {
        
        let max = Math.max(...d.map(dd=>parseFloat(dd.value)));

        d.forEach(datum => {
          let lonlat: [number, number] = [datum.x, datum.y];
          let coordinates = ol.proj.fromLonLat(lonlat);
          let feature = new ol.Feature(
            new ol.geom.Point(coordinates)
          );
          let value = parseFloat(datum.value);
          let color= 'red';

          if(value===max){
            color="yellow";
          }
          let style = new ol.style.Style(
            {
              image: new ol.style.Circle({
                radius:7,
                fill: new ol.style.Fill({
                  color:color
                }),
                stroke:new ol.style.Stroke({
                  color:'blue'
                })
              
              })
            }
          )

          feature.setStyle(style);
          feature.setProperties({name:datum.name,value:datum.value});
          this.vectorSource.addFeature(feature);
        })

      });
  }

  public getPricesmap(range,dateFrom,dateTo,shopName,productName){
    return this.httmp.get(`${API_END_POINT}prices?range=range,dateFrom=dateFrom`);
    }
  onSearch(range, dateFrom, dateTo, shopName, productName) {

    let coordinates = this.map.getView().getCenter();
    let lonlat = ol.proj.toLonLat(coordinates);
    let object = {
      x: lonlat[0],
      y: lonlat[1],
      name: this.form_name,
      rangeFromSpot: range
    }

    console.log(lonlat[0],lonlat[1],range,dateFrom,dateTo,shopName,productName);

    this.vectorSource.clear();

    this.httmp.post(API_END_POINT, object)
      .toPromise().then(d => {
        this.getMyPois();
      })
      this.getPricesmap(range,dateFrom,dateTo,shopName,productName);

    }
}