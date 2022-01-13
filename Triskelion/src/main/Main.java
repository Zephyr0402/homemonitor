package main;
import java.net.SocketException;

/**
 * Triskelion is the control hub of the homemonitor system, named after S.H.I.E.L.D headquarter.*/
public class Main {

    public static void main(String[] args) throws SocketException {
	// write your code here
        Agent agent = new Agent();
        agent.start();
    }
}
