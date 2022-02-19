package com.example;

import com.example.DB.Read;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RequestMapping("/reader")
@RestController
public class ReadNodes {
    @Value("${server.port}")
    private String port;

    @GetMapping("/read")
    public String Read() {

        Read com = new Read();
        JSONArray companies = com.read();

        return ""+ companies;
//        return "Reading from the node on port: " + port
//                + "<br>" + companies;

    }

    public static void main(String[] args) {
        SpringApplication.run(ReadNodes.class, args);
    }

}
