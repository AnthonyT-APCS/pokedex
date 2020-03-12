package dynamoDB;

import java.util.Iterator;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Index;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;

public class PokeDB {
	private static AmazonDynamoDB client;
	private static DynamoDB dynamoDB;
	
	public static void main(String[] args) {
		getType("Grass");
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
	}
	
	public static ItemCollection<QueryOutcome> getType(String type) {
		init();
		
		dynamoDB = new DynamoDB(client);
		Table poketable = dynamoDB.getTable("Poked");
		Index sktype2 = poketable.getIndex("SK-SecondaryType-index");
		Index type2sk = poketable.getIndex("SecondaryType-index");
		
		QuerySpec spec1 = new QuerySpec().withKeyConditionExpression("SK = :type1")
				.withValueMap(new ValueMap().withString(":type1" ,type));
		
		QuerySpec spec2 = new QuerySpec().withKeyConditionExpression("SecondaryType = :type2")
				.withValueMap(new ValueMap().withString(":type2" ,type));
		
		
		ItemCollection<QueryOutcome> items = null;
        Iterator<Item> iterator = null;
        Item item = null;

        try {
            System.out.println("Querying " + type + " types");
            items = type2sk.query(spec2);
            
            iterator = items.iterator();
            while (iterator.hasNext()) {
                item = iterator.next();
                System.out.println(item.getString("PK"));
            }

        }
        catch (Exception e) {
            System.err.println("Unable to query " + type + " type pokemon");
            System.err.println(e.getMessage());
        }
        return items;
	}
}
