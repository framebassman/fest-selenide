package tech.romashov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

import static spark.Spark.get;

public class Server {
    private Logger logger = LoggerFactory.getLogger(Server.class);

    public Server() {
        Spark.staticFileLocation("/webapp/public");
    }

    public void run() {
        logger.info("Start Server");
        get("/healthcheck", (request, response) -> "ok");
    }

    public String url() {
        return "http://127.0.0.1:4567";
    }
}
