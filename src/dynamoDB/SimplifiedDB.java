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
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;

public class SimplifiedDB {
	
	private static AmazonDynamoDB client;
	private static DynamoDB dynamoDB;
	private static Table poketable;
	
	private static void main(String[] args) {
		ArrayList<Item> typeArray = getType("type:grass");
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
		
		QuerySpec spec = new QuerySpec().withKeyConditionExpression("begins_with(TYPE, :type)")
				.withValueMap(new ValueMap().withString(":type", "TYPE: " + type));
		
		ItemCollection<QueryOutcome> items = null;
        Iterator<Item> iterator = null;
        Item item = null;

        try {
            System.out.println("Querying " + type + " primary type pokemon");
            items = poketable.query(spec);
            
            iterator = items.iterator();
            while (iterator.hasNext()) {
                item = iterator.next();
                itemArray.add(item);
                System.out.println(item.getString("PKMN-TYPE"));
            }

        }
        catch (Exception e) {
            System.err.println("Unable to query " + type + " type pokemon");
            System.err.println(e.getMessage());
        }
        
        return itemArray;
	}
}
