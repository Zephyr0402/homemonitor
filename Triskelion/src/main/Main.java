package main;
import org.springframework.boot.SpringApplication;

import java.net.SocketException;
import java.util.Collections;

/**
 * Triskelion is the control hub of the homemonitor system, named after S.H.I.E.L.D headquarter.*/
public class Main {

    public static void main(String[] args) throws SocketException {
        Vault vault = new Vault("vault");
        Agent agent = new Agent(vault);
        SpringApplication app = new SpringApplication(Slingshot.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", Slingshot.getLighthousePort()));
        agent.start();
    }
}
