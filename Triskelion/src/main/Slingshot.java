package main;

import com.google.common.flogger.FluentLogger;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Sending message to Vault and Lighthouse*/
public class Slingshot {
    private static String vaultAddress = "";
    private static String lighthouseAddress = "";
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    static {
        String locationFile = "./location.json";
        try {
            InputStream is = new FileInputStream(locationFile);
            JSONTokener token = new JSONTokener(is);
            JSONObject obj = new JSONObject(token);
            vaultAddress = obj.getString("vault");
            lighthouseAddress = obj.getString("lighthouse");
            is.close();
        } catch (FileNotFoundException e) {
            logger.atInfo().withCause(e).log("Location file not found!");
        } catch (IOException e) {
            logger.atInfo().withCause(e).log("InputStream closing error!");
        }


    }


    public static boolean shootTempSensorDataToVault() {
        return true;
    }
}
