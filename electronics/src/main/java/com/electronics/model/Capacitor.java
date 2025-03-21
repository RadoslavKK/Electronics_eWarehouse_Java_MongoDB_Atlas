package com.electronics.model;

import org.bson.Document;

public class Capacitor {
    private String type;
    private double faradValue;
    private double price;
    private int amount;

    public Capacitor(String type, double faradValue, double price, int amount) {
        this.type = type;
        this.faradValue = faradValue;
        this.price = price;
        this.amount = amount;
    }

    // Convert to MongoDB Document
    public Document toDocument() {
        return new Document("type", type)
                .append("faradValue", faradValue)
                .append("price", price)
                .append("amount", amount);
    }

    // Create from MongoDB Document
    public static Capacitor fromDocument(Document doc) {
        return new Capacitor(
                doc.getString("type"),
                doc.getDouble("faradValue"),
                doc.getDouble("price"),
                doc.getInteger("amount"));
    }

    @Override
    public String toString() {
        return "Capacitor | Type: " + type +
                ", Farads: " + faradValue +
                ", Price: $" + price +
                ", Amount: " + amount;
    }
}