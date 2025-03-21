package com.electronics.model;

import org.bson.Document;

public class Resistor {
    private double resistance;
    private double price;
    private int amount;

    public Resistor(double resistance, double price, int amount) {
        this.resistance = resistance;
        this.price = price;
        this.amount = amount;
    }

    // Convert to MongoDB Document
    public Document toDocument() {
        return new Document("resistance", resistance)
                .append("price", price)
                .append("amount", amount);
    }

    // Create from MongoDB Document
    public static Resistor fromDocument(Document doc) {
        return new Resistor(
                doc.getDouble("resistance"),
                doc.getDouble("price"),
                doc.getInteger("amount"));
    }

    @Override
    public String toString() {
        return "Resistor | Resistance: " + resistance + "Ω, Price: $" + price + ", Amount: " + amount;
    }
}