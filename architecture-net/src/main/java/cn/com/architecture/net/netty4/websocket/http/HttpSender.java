package cn.com.architecture.net.netty4.websocket.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 发送http请求
 */
public class HttpSender {
    static Logger logger = LoggerFactory.getLogger(HttpSender.class);
    private static String IP = "127.0.0.1";// 服务器地址
    private int PORT;// HTTP端口
    public static String key = "legend";

    public HttpSender(int PORT) {
        this.PORT = PORT;
    }

    /*
         * 发给服务端
         */
    public synchronized void socket(int cmd) {
        try {
            Socket socket = new Socket(IP, PORT);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GET /?");
            Map<String, String> map = new HashMap<>();
            map.put("cmd", String.valueOf(cmd));
            stringBuilder.append(HttpHelper.buildUrl(map));
            stringBuilder.append(" HTTP/1.1\r\n");
            bw.write(stringBuilder.toString());
            bw.flush();
            bw.close();
            socket.close();
            logger.info("HttpSender.socket：" + IP + ":" + PORT + " " + stringBuilder.toString());
        } catch (IOException e) {
            logger.info("HttpSender.socket异常：" + e.toString());
        }
    }

    public int getPORT() {
        return PORT;
    }

    public void setPORT(int PORT) {
        this.PORT = PORT;
    }
}
