package com.example.loadbalancer;

import com.example.loadbalancer.DB.Read;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@SpringBootApplication
@RequestMapping("/reader")
@RestController
public class ReadNodes {
    @Value("${server.port}")
    private String port;

    @GetMapping("/read")
    public String Read() {

        Read com = new Read();
        List companies = com.read();
        // PrintWriter out = resp.getWriter();

        //   out.println(companies);
        //   return "application is up on port : " + port + response.body();
        return "Reading from the node on port: " + port
                + "<br>" + companies;


    }

    public static void main(String[] args) {
        SpringApplication.run(ReadNodes.class, args);
    }

}
