package lxt.project.myapplication.helper;

public class Consts {

    private static final String HOST_DOMAIN = "http://529.vn/";
    private static final String HOST_DEV = "http://ninomotor.qtctek.com/";
    private static final String LOCALHOST = "http://192.168.100.27:80/api_nino_customer/";

    public static final String HOST_API = HOST_DEV;

    public static final String REST_ENDPOINT = "api/";
    public static final String HEADES = "Authorization:Basic YWRtaW46cXRjdGVrQDEyMwx==";
    public static final int REQUEST_CODE_AUTOCOMPLETE = 222;
    public static final int REQUEST_CODE_GPS = 120;

    private static final String MODE_PRODUCTION = "production";
    private static final String MODE_DEBUG = "debug";
    public static final boolean TRUST_CERTIFICATE = false;


    public static final String MODE = MODE_DEBUG;

    public static final String TAG_FRAGMENT_CHECK = "FragmentCheck";

    public static final int LOCATION_INTERVAL = 10000;
    public static final int FASTEST_LOCATION_INTERVAL = 5000;

    public class URLConsts {
        public static final String SOCKET_TABLE_URL = "http://192.168.100.16:3000/";
    }

    public class SocketEvent {
        public static final String TOA_DO = "toa-do";
    }

    public class SocketEmit {

    }
}
