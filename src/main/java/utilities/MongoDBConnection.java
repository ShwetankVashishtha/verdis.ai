package utilities;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {

    MongoClient mongoClient;
    MongoDatabase mongoDatabase;
    MongoCollection mongoCollection;

    public void connectDatabase(String dbUrl, int dbPort) {
        mongoClient = new MongoClient(dbUrl, dbPort);
    }

    public void getDB(String dbName) {
        mongoDatabase = mongoClient.getDatabase(dbName);
    }

    public void getCollection(String collectionName) {
        mongoCollection = mongoDatabase.getCollection(collectionName);
    }

    public void closeDatabase() {
        mongoClient.close();
    }
}
