package server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class SampleHttpServer {

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 9080), 0);
            server.createContext("/hello", new HelloHandler());
            server.setExecutor(Executors.newFixedThreadPool(5));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
