package main;

import com.google.common.flogger.FluentLogger;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;
import sensor.TemperatureSensor;

public class Vault {
    private MongoClient client;
    private MongoDatabase database;
    private final static FluentLogger logger = FluentLogger.forEnclosingClass();
    private final int entryNum = 720;

    public Vault(String databaseName) {
        this.client = new MongoClient(Slingshot.getVaultAddress(), Integer.parseInt(Slingshot.getVaultPort()));
        try {
            this.database = this.client.getDatabase(databaseName);
        } catch (IllegalArgumentException e) {
            logger.atInfo().withCause(e).log("Database name is not valid!");
            e.printStackTrace();
        }
//        this.database.createCollection("TemperatureSensor");
    }

    public void close() {
        this.client.close();
    }

    public boolean storeTemperatureData(TemperatureSensor data) {
        MongoCollection<Document> collection = this.database.getCollection("TemperatureSensor");
        Document document = new Document();
        document.put("temperature", data.getTemperature());
        document.put("humidity", data.getHumidity());
        document.put("metric", data.getMetric());
        if (collection.countDocuments() == this.entryNum) {
            collection.findOneAndDelete(new BsonDocument());
        }
        collection.insertOne(document);
        return true;
    }
}
