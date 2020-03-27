package jsonfile.com;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class Tang_gettingallJsonKeys_and_values {

    static JSONObject jsonObject;
    static Object obj;
    static FileReader jsonfile;
    static String JsonResponseinString;

    public static void main(String[] args) throws IOException, ParseException {

        parsingTheJson();
        gettingAllindividualKeys();
        gettingAllvaluesByKeys();
        gettingAllvaluesByKeys_arrays();
        all_keys();

    }

    public static void parsingTheJson() throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();

        // FileReader jsonfile = new FileReader("src/test/resources/cucumber.json");

        obj = parser.parse(new FileReader("src/test/resources/Tangerine.json"));
        jsonObject = (JSONObject) obj;
        JsonResponseinString = jsonObject.toString();
        System.out.println("JSON Response :: " + JsonResponseinString);

        Set all_Keys = jsonObject.keySet();
        Iterator all_Keys_ite = all_Keys.iterator();
        System.out.println("Keys of complete Json File are :: ");
        while (all_Keys_ite.hasNext()) {
            System.out.print(all_Keys_ite.next());
            System.out.println(" ");

        }
    }

    public static void gettingAllindividualKeys() throws FileNotFoundException, IOException, ParseException {
        System.out.println(" ");
        System.out.println(" All Individual keys with values  are");

        Object orderNumber = jsonObject.get("orderNumber");
        System.out.println("orderNumber is " + orderNumber);

        Object versionNumber = jsonObject.get("versionNumber");
        System.out.println("versionNumber is " + versionNumber);

        Object companyId = jsonObject.get("companyId");
        System.out.println("companyId is " + companyId);

        Object banner = jsonObject.get("banner");
        System.out.println("banner is " + banner);

        Object storeNumber = jsonObject.get("storeNumber");
        System.out.println("storeNumber is " + storeNumber);

        Object orderCreatedDate = jsonObject.get("orderCreatedDate");
        System.out.println("orderCreatedDate is " + orderCreatedDate);

        Object messageAction = jsonObject.get("messageAction");
        System.out.println("messageAction is " + messageAction);

        Object fulfillmentSystem = jsonObject.get("fulfillmentSystem");
        System.out.println("fulfillmentSystem is " + fulfillmentSystem);

        String sourceInfo = jsonObject.get("sourceInfo").toString();
        System.out.println("sourceInfo is " + sourceInfo);
        String orderTotal = jsonObject.get("paymentDetails").toString();
        System.out.println("orderTotal is " + orderTotal);

        String customer = jsonObject.get("customer").toString();
        System.out.println("customer is " + customer);

        Object cut = jsonObject.get("customer[0].customerId");
        System.out.println(cut);
    }

    public static void gettingAllvaluesByKeys() {

        Object valueOfsourceInfo = jsonObject.get("sourceInfo");

        System.out.println("Value Of sourceInfo is ::   " + valueOfsourceInfo);

        Object valueOforderTotal = jsonObject.get("orderTotal");

        System.out.println("Value Of orderTotal is ::  " + valueOforderTotal);

        Object valueOfcustomer = jsonObject.get("customer");

        System.out.println("Value Of customer is ::  " + valueOfcustomer);

        Object valueOfpreference = jsonObject.get("preference");

        System.out.println("Value Of preference is ::  " + valueOfpreference);

    }

    public static void gettingAllvaluesByKeys_arrays() {


        String paymentDetails = jsonObject.get("paymentDetails").toString();
        String subOrders = jsonObject.get("subOrders").toString();


    }

    public static void all_keys() {

        // Set<String> keys = jsonObject.keySet();

        JSONArray paymentDetails_jsonArray = (JSONArray) jsonObject.get("paymentDetails");
        System.out.println("");
        System.out.println("paymentDetails: ");
        //Iterating the contents of the array
        Iterator ite1 = paymentDetails_jsonArray.iterator();
        while (ite1.hasNext()) {
            System.out.print(ite1.next());
        }

        JSONArray subOrders_jsonArray = (JSONArray) jsonObject.get("subOrders");
        System.out.println("");
        System.out.println("subOrders details: ");
        //Iterating the contents of the array
        Iterator ite2 = subOrders_jsonArray.iterator();
        while (ite2.hasNext()) {
            System.out.print(ite2.next());
        }

        JSONObject cut = (JSONObject) jsonObject.get("orderTotal");

        Set cuts = cut.keySet();
        Iterator c = cuts.iterator();
        while(c.hasNext())
        {
            System.out.print(c.next());
        }


        JSONArray cutdd = (JSONArray) jsonObject.get("paymentDetails");


    }
}
