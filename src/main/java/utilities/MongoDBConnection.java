package utilities;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBConnection {

    MongoClient mongoClient;
    PropertyManager propertyManager = new PropertyManager();

    public void openConnection(String dbUrl) {
        mongoClient = new MongoClient(dbUrl, 27017);
    }

    public MongoDatabase getDB() {
        return mongoClient.getDatabase(propertyManager.getResourceBundle.getProperty("mongo.db.name"));
    }

    public MongoCollection<Document> getCollection() {
        return getDB().getCollection(propertyManager.getResourceBundle.getProperty("mongo.db.collection.name"));
    }

    public void closeConnection() {
        mongoClient.close();
    }

    public Document showContentInCollection() {
        FindIterable<Document> findIterable = getCollection().find();
        if (findIterable.iterator().hasNext())
            System.out.println(findIterable.iterator().next());
        return findIterable.iterator().next();
    }
}
