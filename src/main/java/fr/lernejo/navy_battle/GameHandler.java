package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        InputStreamReader isr =  new InputStreamReader(exchange.getRequestBody(),"utf-8");
        BufferedReader br = new BufferedReader(isr);
        int b;
        StringBuilder buf = new StringBuilder();
        while ((b = br.read()) != -1) {
            buf.append((char) b);
        }
        br.close();
        isr.close();
        String str = buf.toString();
        JSONObject jsObject = new JSONObject(str);
        try {
            if (jsObject.getString("id") != null && jsObject.getString("url") != null && jsObject.getString("message") != null){
                exchange.sendResponseHeaders(202, str.getBytes().length);
            }
        } catch(Exception e){
            exchange.sendResponseHeaders(400, str.getBytes().length);
        }
    }
}
