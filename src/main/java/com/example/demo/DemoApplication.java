package com.example.demo;

import org.neo4j.driver.*;
import org.neo4j.driver.Record;
import org.springframework.boot.SpringApplication;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public class DemoApplication {


    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "12345678"));
        Session session = driver.session();
        //addLugar(session, "casa", 40, 1920);
        deleteLugar(session, "casa");
        //addRelacion(session, "casa", "Casa 2", "Conduce", 100);
        session.close();
        driver.close();

    }

    public static void addLugar(Session session, String name, int height, int year) {
        Result result = session.run("CREATE (lugar:Lugar {nombre: '" + name + "', altura: "+ height +", año: " + year + "})");
        while (result.hasNext()) {
            Record record = result.next();
        }
    }

    public static void addRelacion(Session session, String name1, String name2, String relation, int distance) {
        Result result = session.run("MATCH (a:Lugar), (b:Lugar) WHERE a.nombre = '" + name1 + "' AND b.nombre = '"+name2+"' CREATE (a)-[r:"+relation+" {distancia: "+distance+"}]->(b) RETURN type(r)");
        while (result.hasNext()) {
            Record record = result.next();
        }
    }

    public static void deleteLugar(Session session, String name) {
        Result result = session.run("MATCH (n:Lugar {nombre: '"+name+"'}) DETACH DELETE n");
        while (result.hasNext()) {
            Record record = result.next();
        }
    }

}


