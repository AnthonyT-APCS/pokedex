package dynamoDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Index;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;

public class PokeDB {
	private static AmazonDynamoDB client;
	private static DynamoDB dynamoDB;
	private static Table poketable;
	private static Index skIndex;
	private static Index type2Index;
	private static Index skpkIndex;
	
	public static void main(String[] args) {
		ArrayList<Item> itemArray = searchPokemon("Grass", "O");
	}
	
	private static void init() {
		ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
        try {
            credentialsProvider.getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (/Users/johnmortensen/.aws/credentials), and is in valid format.",
                    e);
        }
        client = AmazonDynamoDBClientBuilder.standard()
        	.withCredentials(credentialsProvider)
            .withRegion("us-west-2")
            .build();
        
        dynamoDB = new DynamoDB(client);
        poketable = dynamoDB.getTable("Poked");
        skIndex = poketable.getIndex("SK-index");
        type2Index = poketable.getIndex("SecondaryType-index");
        skpkIndex = poketable.getIndex("SK-PK-index");
	}
	
	public static ArrayList<Item> getType(String type) {
		init();
		
		ArrayList<Item> itemArray = new ArrayList<>();
		Index skIndex = poketable.getIndex("SK-index");
		Index type2Index = poketable.getIndex("SecondaryType-index");
		
		QuerySpec spec1 = new QuerySpec().withKeyConditionExpression("SK = :type1")
				.withValueMap(new ValueMap().withString(":type1" ,type));
		
		QuerySpec spec2 = new QuerySpec().withKeyConditionExpression("SecondaryType = :type2") //Can do something with db to only return first evolution pokemon
				.withValueMap(new ValueMap().withString(":type2" ,type));
		
		ItemCollection<QueryOutcome> items = null;
        Iterator<Item> iterator = null;
        Item item = null;

        try {
            System.out.println("Querying primary " + type + " types");
            items = skIndex.query(spec1);
            
            iterator = items.iterator();
            while (iterator.hasNext()) {
                item = iterator.next();
                itemArray.add(item);
                System.out.println(item.getString("PK"));
            }

        }
        catch (Exception e) {
            System.err.println("Unable to query " + type + " type pokemon");
            System.err.println(e.getMessage());
        }

        try {
            System.out.println("Querying secondary " + type + " types");
            items = type2Index.query(spec2);
            
            iterator = items.iterator();
            while (iterator.hasNext()) {
                item = iterator.next();
                itemArray.add(item);
                System.out.println(item.getString("PK"));
            }

        }
        catch (Exception e) {
            System.err.println("Unable to query " + type + " type pokemon");
            System.err.println(e.getMessage());
        }
        
        return itemArray;
	}
	
	public static Item getPokemon(String name, String type) {
		init();
		
		GetItemSpec spec = new GetItemSpec().withPrimaryKey("PK", name, "SK", type);
		Item item = poketable.getItem(spec);
		
		return item;
	}
	
	public static ArrayList<Item> searchPokemon(String query) {
		init();
		
		ArrayList<Item> itemArray = new ArrayList<>();
		
		QuerySpec spec = new QuerySpec().withKeyConditionExpression("begins_with(PK, :name)")
				.withValueMap(new ValueMap().withString(":name", query));
		
		ItemCollection<QueryOutcome> items = null;
        Iterator<Item> iterator = null;
        Item item = null;

        try{
        	System.out.println("Querying " + query);
            items = poketable.query(spec);
            iterator = items.iterator();
            while(iterator.hasNext()) {
            	item = iterator.next();
            	itemArray.add(item);
                System.out.println(item.getString("PK"));
            }
        }
        catch(Exception e) {
        	System.err.println("Unable to query pokemon");
        	System.err.println(e.getMessage());
        }
		
		return itemArray;
	}
	
	public static ArrayList<Item> searchPokemon(String type, String query) {
		init();
		
		ArrayList<Item> itemArray = new ArrayList<>();
		
		QuerySpec spec = new QuerySpec().withKeyConditionExpression("SK = :type and begins_with(PK, :name)")
				.withValueMap(new ValueMap().withString(":type", type).withString(":name", query));
		
		ItemCollection<QueryOutcome> items = null;
        Iterator<Item> iterator = null;
        Item item = null;

        try{
        	System.out.println("Querying " + query);
            items = skpkIndex.query(spec);
            iterator = items.iterator();
            while(iterator.hasNext()) {
            	item = iterator.next();
            	itemArray.add(item);
                System.out.println(item.getString("PK"));
            }
        }
        catch(Exception e) {
        	System.err.println("Unable to query pokemon");
        	System.err.println(e.getMessage());
        }
		
		return itemArray;
	}
}
