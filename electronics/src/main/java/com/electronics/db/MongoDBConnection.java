package com.electronics.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MongoDBConnection {
    private static MongoClient client = null;
    private static final String DATABASE_NAME = "ElectronicsDB";
    private static String URI;

    // Read the password from a file and construct the URI
    static {
        // .txt file will not be pushed to GitHub for Seurity Reasons.
        try (BufferedReader reader = new BufferedReader(new FileReader("password.txt"))) {
            String password = reader.readLine().trim();

            // Maybe Change URL?
            URI = "mongodb+srv://ElectronicsDBUser:" + password + "@null/?retryWrites=true&w=majority&appName=Cluster0";
        } catch (IOException e) {
            System.err.println("Failed to read password file.");
            e.printStackTrace();
        }
    }

    // Get the data(Collection) from MongoDB
    public static MongoCollection<Document> getCollection(String name) {
        if (client == null) {
            client = MongoClients.create(URI);
        }
        MongoDatabase database = client.getDatabase(DATABASE_NAME);
        return database.getCollection(name);
    }

    // Close MongoDB Atlast connection
    public static void close() {
        if (client != null) {
            client.close();
            client = null;
        }
    }
}