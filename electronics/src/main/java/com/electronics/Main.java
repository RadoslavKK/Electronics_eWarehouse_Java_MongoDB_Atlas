package com.electronics;

import com.electronics.model.*;
import com.electronics.service.ComponentService;
import com.electronics.db.MongoDBConnection;
import org.bson.Document;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ComponentService service = new ComponentService();

        /*
         * 
         * This is a learning project to help me explore MongoDB Atlas and improve my
         * Java development skills.
         * There are still some bugs to fix.
         * I plan to add an option-based menu/user interface and include more features
         * for sorting the warehouse components.
         * 
         */

        // Add example components to the database
        service.addComponent("transistors", new Transistor("NPN", 0.15, 100).toDocument());
        service.addComponent("transistors", new Transistor("MOS", 0.25, 50).toDocument());

        service.addComponent("resistors", new Resistor(220.0, 0.05, 500).toDocument());
        service.addComponent("resistors", new Resistor(1000.0, 0.08, 300).toDocument());

        service.addComponent("diodes", new Diode("LED", 0.10, 300).toDocument());
        service.addComponent("diodes", new Diode("Schottky", 0.12, 150).toDocument());

        service.addComponent("capacitors", new Capacitor("ceramic", 0.000001, 0.12, 200).toDocument());
        service.addComponent("capacitors", new Capacitor("electrolytic", 0.00001, 0.20, 100).toDocument());

        // This will be more of a option in the menu_________

        // Print all transistors
        System.out.println("\n📦 All Transistors:");
        List<Document> transistors = service.getAllComponents("transistors");
        for (Document doc : transistors) {
            System.out.println(Transistor.fromDocument(doc));
        }

        // Remove Latter
        // Print all resistors sorted by price -Check if it works?
        System.out.println("\n💡 Resistors Sorted by Price:");
        List<Document> sortedResistors = service.getSortedByPrice("resistors");
        for (Document doc : sortedResistors) {
            System.out.println(Resistor.fromDocument(doc));
        }

        // Need to add a menu - Option for user controll___________________-

        // Delete a specific component
        service.deleteComponent("diodes", "type", "Schottky");
        System.out.println("\n Deleted Diode with type: Schottky");

        // Show remaining diodes
        System.out.println("\n🔎 Remaining Diodes:");
        List<Document> diodes = service.getAllComponents("diodes");
        for (Document doc : diodes) {
            System.out.println(Diode.fromDocument(doc));
        }

        // Close the DB connection when done
        MongoDBConnection.close();
    }
}