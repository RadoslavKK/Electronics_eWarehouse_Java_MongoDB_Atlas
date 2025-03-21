package com.electronics.model;

import org.bson.Document;

public class Diode {
    private String type;
    private double price;
    private int amount;

    public Diode(String type, double price, int amount) {
        this.type = type;
        this.price = price;
        this.amount = amount;
    }

    // Convert to MongoDB Document
    public Document toDocument() {
        return new Document("type", type)
                .append("price", price)
                .append("amount", amount);
    }

    // Create from MongoDB Document
    public static Diode fromDocument(Document doc) {
        return new Diode(
                doc.getString("type"),
                doc.getDouble("price"),
                doc.getInteger("amount"));
    }

    @Override
    public String toString() {
        return "Diode | Type: " + type + ", Price: $" + price + ", Amount: " + amount;
    }
}