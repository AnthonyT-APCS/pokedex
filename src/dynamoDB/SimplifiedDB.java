package dynamoDB;

import java.util.ArrayList;
import java.util.Iterator;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Index;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;

public class SimplifiedDB {
	private static AmazonDynamoDB client;
	private static DynamoDB dynamoDB;
	private static Table poketable;
	
	public static void main(String[] args) {
		init();
		//ArrayList<Item> typeArray = getType("grass");
		Item item = poketable.getItem("regionPK", "region#kanto", "nameSK", "pkmn#bulbasaur");
		System.out.println(item.getString("nameSK"));
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
        poketable = dynamoDB.getTable("Pokedex");
	}

	public static ArrayList<Item> getType(String type) {
		init();
		ArrayList<Item> itemArray = new ArrayList<>();
		
		QuerySpec spec = new QuerySpec().withKeyConditionExpression("regionPK = :reg and begins_with(nameSK, :name)")
				.withFilterExpression("typeMAIN = :type")
				.withValueMap(new ValueMap().withString(":reg", "region#kanto").withString(":name", "pkmn#").withString(":type", type));
		
		ItemCollection<QueryOutcome> items = null;
        Iterator<Item> iterator = null;
        Item item = null;

        try {
            System.out.println("Querying " + type + " primary type pokemon");
            items = poketable.query(spec);
            System.out.println("aaa");
            iterator = items.iterator();
            while (iterator.hasNext()) {
                item = iterator.next();
                itemArray.add(item);
                System.out.println(item.getString("namePK"));
            }

        }
        catch (Exception e) {
            System.err.println("Unable to query " + type + " type pokemon");
            System.err.println(e.getMessage());
        }
        
        return itemArray;
	}
}
