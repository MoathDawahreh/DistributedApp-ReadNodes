package com.example.loadbalancer;

import com.example.loadbalancer.DB.Read;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


@SpringBootApplication
@RequestMapping("/reader")
@RestController
public class LoadBalanceApplication {
    @Value("${server.port}")
    private String port;

    @GetMapping("/read")
    public String Read() {

        Read com = new Read();
        List companies = com.read();
        // PrintWriter out = resp.getWriter();

        //   out.println(companies);
        //   return "application is up on port : " + port + response.body();
        return "Reading from node/ port : " + port
                + "<br> <br>" + companies;


    }

    public static void main(String[] args) {
        SpringApplication.run(LoadBalanceApplication.class, args);
    }

}
