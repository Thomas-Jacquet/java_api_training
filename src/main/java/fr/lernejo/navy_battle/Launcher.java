package fr.lernejo.navy_battle;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


public class Launcher {

    public static void main(String[] args) throws IOException, InterruptedException {

        if (args.length == 1){
            Server server = new Server(args[0]);
            server.start();
        }

        else if (args.length == 2) {
            int client_port = Integer.parseInt(args[0]);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request_post = HttpRequest.newBuilder()
                .uri(URI.create(args[1] + "/api/start/game"))
                .setHeader("Accept", "application/json")
                .setHeader("Content-Type", "application/json")
                .POST(BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + client_port + "\", \"message\":\"Hello\"}"))
                .build();
            HttpResponse<String> response = client.send(request_post, BodyHandlers.ofString());
            System.out.println(response.body());
        }

        else{
            System.out.println("Bad argument");
            System.exit(-1);
        }
        
    }
}
