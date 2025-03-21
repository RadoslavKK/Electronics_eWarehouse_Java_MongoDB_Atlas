package com.electronics.service;

import com.electronics.db.MongoDBConnection;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ComponentService {

    // Add a new component to a collection 
    public void addComponent(String collectionName, Document document) {
        MongoCollection<Document> collection = MongoDBConnection.getCollection(collectionName);
        collection.insertOne(document);
    }

    // Delete a component from a collection by a field and its value
    public void deleteComponent(String collectionName, String field, Object value) {
        MongoCollection<Document> collection = MongoDBConnection.getCollection(collectionName);
        collection.deleteOne(new Document(field, value));
    }

    // Get all components from a collection
    public List<Document> getAllComponents(String collectionName) {
        MongoCollection<Document> collection = MongoDBConnection.getCollection(collectionName);
        List<Document> list = new ArrayList<>();
        for (Document doc : collection.find()) {
            list.add(doc);
        }
        return list;
    }

    // Get components sorted by price : Ascending
    public List<Document> getSortedByPrice(String collectionName) {
        MongoCollection<Document> collection = MongoDBConnection.getCollection(collectionName);
        List<Document> list = new ArrayList<>();
        FindIterable<Document> docs = collection.find().sort(Sorts.ascending("price"));
        for (Document doc : docs) {
            list.add(doc);
        }
        return list;
    }
}