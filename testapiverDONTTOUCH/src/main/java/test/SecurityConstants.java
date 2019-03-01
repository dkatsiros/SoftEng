package test;


public class SecurityConstants {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "";
    public static final String HEADER_STRING = "X-OBSERVATORY-AUTH";
    public static final String SIGN_UP_URL = "/users/sign-up";
}
