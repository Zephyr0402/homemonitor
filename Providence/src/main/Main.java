package main;

import com.google.common.flogger.FluentLogger;

import java.net.SocketException;

public class Main {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public static void main(String[] args) {
	// write your code here
        try {
            Agent agent = new Agent();
            agent.start();
        } catch (SocketException e) {
            logger.atInfo().withCause(e).log("Providence starts failed!");
            e.printStackTrace();
        }

    }
}
