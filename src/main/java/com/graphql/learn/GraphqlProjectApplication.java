package com.graphql.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphqlProjectApplication {

    @Autowired

    public static void main(String[] args) {
        SpringApplication.run(GraphqlProjectApplication.class, args);

    }

}
