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
        String str = "http://localhost:7561";
        exchange.sendResponseHeaders(202, str.getBytes().length);
    }
}
