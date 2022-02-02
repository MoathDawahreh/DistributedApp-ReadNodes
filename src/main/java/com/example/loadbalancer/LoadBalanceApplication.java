package com.example.loadbalancer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@SpringBootApplication
@RequestMapping("/reader")
@RestController
 public class LoadBalanceApplication {
    @Value("${server.port}")
    private String port;

    @GetMapping("/read")
    public String chatNow() {


        HttpResponse<String> response = null;
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:9090/DocumentDB-1.0-SNAPSHOT/Master"))
                    .header("Authorization", "redOnly")
                    //  .header("Authorization", basicAuth("username", "password"))

                    .build();


            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //  System.out.println(response.body());
           // out.println(response.body());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "application is up on port : " + port + response.body();
    }

    public static void main(String[] args) {
        SpringApplication.run(LoadBalanceApplication.class, args);
    }

}
