import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';


export const token: string = 'jwt_token';

export class GetToken {
 getToken() : string {
    return localStorage.getItem(token);
   }

};