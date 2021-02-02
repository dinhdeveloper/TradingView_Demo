package lxt.project.myapplication.helper;


import android.os.Handler;
import android.text.TextUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.json.JSONObject;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import b.laixuantam.myaarlibrary.helper.MyLog;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import lxt.project.myapplication.model.socket.param.BaseSocketParam;

public class MySocket {
    private static MySocket mInstance;
    private Socket mSocket;
    private Gson gson = new Gson();
    private Handler handler = new Handler();

    public static MySocket getInstance() {
        if (mInstance == null) {
            mInstance = new MySocket();
        }
        return mInstance;
    }

    public void init() {
        try {
//            RelaxedHostNameVerifier hostNameVerifier = new RelaxedHostNameVerifier();
//            IO.setDefaultHostnameVerifier(hostNameVerifier);

            IO.Options opts = new IO.Options();
            opts.forceNew = true;
            opts.secure = true;
            opts.reconnection = true;
//            if (AppProvider.getPreferences().getUser() == null || AppProvider.getPreferences()
//                    .getSelectBranch() == null)
//            {
//                return;
//            }

//            opts.query = "token=" + AppProvider.getPreferences()
//                    .getUser()
//                    .getToken() + "&branch=" + AppProvider.getPreferences()
//                    .getSelectBranch()
//                    .getId();
//            Log.e("Socket", "Token: " + AppProvider.getPreferences()
//                    .getUser()
//                    .getToken() + " | " + "Branch: " + AppProvider.getPreferences()
//                    .getSelectBranch()
//                    .getId());
            mSocket = IO.socket(Consts.URLConsts.SOCKET_TABLE_URL);
            mSocket.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Socket getSocket() {
        if (mSocket == null) {
            init();
        } else if (!mSocket.connected()) {
            mSocket.connect();
        }

        return mSocket;
    }

    public boolean checkSocketConectedStatus() {
        if (mSocket != null) {
            MyLog.d("on socket: ConectedStatus: " + mSocket.connected());
            return mSocket.connected();
        }
        return false;
    }

    public <M> void on(final String event, final Class<M> classOf, final SocketCallback<M> callback) {
        MyLog.d("on socket: " + event);
        Socket socket = getSocket();
        if (socket != null) {
            // off before on new event
            socket.off(event);

            socket.on(event, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    try {
                        String jsonData = args[0].toString();
                        MyLog.d("socket on data: " + event, jsonData);
                        final M data = gson.fromJson(jsonData, classOf);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                callback.onReceived(data);
                            }
                        });
                    } catch (Exception e) {
                        MyLog.e("Wrong data structure", e.getMessage());
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public <M> void once(final String event, final Class<M> classOf, final SocketCallback<M> callback) {
        MyLog.d("once socket: " + event);
        Socket socket = getSocket();
        if (socket != null) {
            socket.once(event, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    String jsonData = args[0].toString();
                    MyLog.d("socket on data: " + event, jsonData);
                    final M data = gson.fromJson(jsonData, classOf);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onReceived(data);
                        }
                    });
                }
            });
        }
    }

    public void emit(String event, BaseSocketParam param) {
        Socket socket = getSocket();
        if (socket != null) {
            MyLog.d("socket emit data: " + event, param.toString());
            String jsonInString = "";
            ObjectMapper mapper = new ObjectMapper();
            try {
                jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(param);
                if (!TextUtils.isEmpty(jsonInString)) {
                    JSONObject object = new JSONObject(jsonInString);
                    socket.emit(event, object);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void offEvent(String event) {
        MyLog.d("off socket: " + event);
        Socket socket = getSocket();
        if (socket != null) {
            socket.off(event);
        }
    }

    public void offAllEvent() {
        Socket socket = getSocket();
        if (socket != null) {
            socket.off();
        }
    }

    public void connect() {
        Socket socket = getSocket();
        if (socket != null) {
            getSocket().connect();
        }
    }

    public void disconnect() {
        Socket socket = getSocket();
        if (socket != null) {
            getSocket().disconnect();
        }
    }

    public interface SocketCallback<M> {
        void onReceived(M data);
    }

    public static class RelaxedHostNameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

}
