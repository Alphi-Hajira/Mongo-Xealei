package org.mongoDB;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bson.Document;

import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
public class Mango_CRUDOperation {
	
			public static void main(String[] args) {

//			// ************* MongoDB deployment's connection string *************
			String uri = "mongodb+srv://adminXealei:hNntCLqUSkTxbJel@xealei-qa.1of90.mongodb.net/xealeiqa?"
					+ "retryWrites=true&w=majority";

			MongoClient mongoClient = MongoClients.create(uri);

//			// ************* Create one Collection *************
	     	MongoDatabase db = mongoClient.getDatabase("xealeiqa_automate");

//			// ************* get all the DBS in MongoDB *************
			ListDatabasesIterable<Document> listDatabases = mongoClient.listDatabases();
			for (Document x : listDatabases) {
				System.out.println(x);
			}

//			//************* Create one document under collection *************
			MongoCollection<Document> collection = db.getCollection("Alphind");
				//		Document doc = new Document("Name", "QA-Automation");
		//	collection.insertOne(doc);
			System.out.println("Document Inserted successfully..!");
			System.out.println("**********************");
			
//			//************* Create Many Document under one collection *************
			Document d1 = new Document("Name", "Rayen").append("Age", "39").append("City", "North America");
			Document d2 = new Document("Name", "Marie-Thérèse").append("Age", "47").append("City", "Germany");
			Document d3 = new Document("Name", "Navin").append("Age", "65").append("City", "Canada");
			Document d4 = new Document("Name", "Adrienne").append("Age", "44").append("City", "South America");
			Document d5 = new Document("Name", "Ameyalli").append("Age", "55").append("City", "New York");
			List<Document>li=new ArrayList<>();
			li.add(d1);
			li.add(d2);
			li.add(d3);
			li.add(d4);
			li.add(d5);
			collection.insertMany(li);
			
			
//			
//			//************* To update the document with OVERWRITE *************
//	       collection.updateOne(Filters.eq("Name", "Navin"),Updates.set("City", "Chennai"));
//	       System.out.println("Document update successfully..!");
//	       System.out.println("********************************");
			
////			//************* To delete particular document *************
//		db.getCollection("CareTaker").findOneAndDelete(Filters.eq("Name", "Albert"));
//			System.out.println("Document deleted successfully..!");
//		  	System.out.println("********************************");
//		  	
//		  	//************* To delete the collection *************
//		  	db.getCollection("CareTaker").drop();
//		  	System.out.println("Collection deleted successfully..!");
//		  	
		}
	}


