package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private HttpServer srv;

    public Server (String port_str) throws IOException {
        int port = Integer.parseInt(port_str);
        ExecutorService executor = Executors.newFixedThreadPool(1);
        this.srv = HttpServer.create(new InetSocketAddress(port), 0);
        this.srv.createContext("/ping", new PingHandler());
        this.srv.createContext("/api/start/game", new GameHandler());
        this.srv.createContext("/api/game/fire", new NavyFireHandler());
        this.srv.setExecutor(executor);
    }

    public void start () {
        this.srv.start();
    }
}
