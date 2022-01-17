package main;

import com.google.common.flogger.FluentLogger;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sending message to Vault and Lighthouse*/
@SpringBootApplication
@RestController
@Configuration
public class Slingshot {
    private static String vaultAddress = "";
    private static String vaultPort = "";
    private static String lighthouseAddress = "";
    private static String triskelionPort = "";
    private static String lighthousePort = "";
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    static {
        String locationFile = "./location.json";
        try {
            InputStream is = new FileInputStream(locationFile);
            JSONTokener token = new JSONTokener(is);
            JSONObject obj = new JSONObject(token);
            vaultAddress = obj.getString("vaultAddress");
            vaultPort = obj.getString("vaultPort");
            lighthouseAddress = obj.getString("lighthouse");
            triskelionPort = obj.getString("triskelionPort");
            lighthousePort = obj.getString("lighthousePort");
            is.close();
        } catch (FileNotFoundException e) {
            logger.atInfo().withCause(e).log("Location file not found!");
        } catch (IOException e) {
            logger.atInfo().withCause(e).log("InputStream closing error!");
        }
    }

    @GetMapping("/getTemperatureInfo")
    public String getTemperatureInfo() {

        return "hello";
    }

    public static String getTriskelionPort() {
        return triskelionPort;
    }

    public static String getVaultAddress() {
        return vaultAddress;
    }

    public static String getVaultPort() {
        return vaultPort;
    }

    public static String getLighthouseAddress() {
        return lighthouseAddress;
    }

    public static String getLighthousePort() {
        return lighthousePort;
    }

    public static boolean shootTempSensorDataToVault() {
        return true;
    }
}
