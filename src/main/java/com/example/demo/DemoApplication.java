package com.example.demo;

import org.neo4j.driver.*;
import org.neo4j.driver.Record;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.neo4j.driver.Values.parameters;
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("username", "12345678"));
        Session session = driver.session();

    }

    public void addLugar(Session session, String name, int height, int year) {
        Result result = session.run("CREATE (lugar2:Lugar {nombre: " + name + ", altura: "+ height +", año: " + year + "})");
        while (result.hasNext()) {
            Record record = result.next();
            System.out.println(record.get("nombre").asString());
        }
    }

}


