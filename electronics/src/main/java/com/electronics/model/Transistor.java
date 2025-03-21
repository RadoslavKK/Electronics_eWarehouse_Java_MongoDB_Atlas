package com.electronics.model;

import org.bson.Document;

public class Transistor {
    private String type;
    private double price;
    private int amount;

    public Transistor(String type, double price, int amount) {
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
    public static Transistor fromDocument(Document doc) {
        return new Transistor(
                doc.getString("type"),
                doc.getDouble("price"),
                doc.getInteger("amount"));
    }

    @Override
    public String toString() {
        return "Transistor | Type: " + type + ", Price: $" + price + ", Amount: " + amount;
    }
}