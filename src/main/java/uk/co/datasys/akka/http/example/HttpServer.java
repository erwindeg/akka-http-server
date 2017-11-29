package uk.co.datasys.akka.http.example;

import akka.actor.ActorSystem;
import akka.http.javadsl.server.HttpApp;
import akka.http.javadsl.server.Route;

import java.io.IOException;

public class HttpServer extends HttpApp {

    public static void main(String[] args) throws IOException {
        ActorSystem system = ActorSystem.create();

        new HttpServer().bindRoute("localhost", 8080, system);
    }
    @Override
    public Route createRoute() {
        Route helloRoute = handleWith((ctx)
                -> ctx.complete("Hello World!"));

        return route(get(path("hello").route(helloRoute)));
    }
}
