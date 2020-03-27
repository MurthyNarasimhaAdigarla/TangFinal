package jsonfile.com;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class TangJsonUtils {

   public static JSONObject jsonObject;
    static Object obj;
    static FileReader jsonfile;
    static String JsonResponseinString;

    public static void main(String[] args) throws IOException, ParseException {

        parsingTheJson();
        gettingAllindividualKeys() ;

    }

    public static void parsingTheJson() throws IOException, ParseException {
        //FileReader jsonfile = new FileReader("src/test/resources/cucumber.json");
        JSONParser parser = new JSONParser();
        obj = parser.parse(new FileReader("src/test/resources/Tangerine.json"));
        jsonObject = (JSONObject) obj;
        JsonResponseinString = jsonObject.toString();
        System.out.println("JSON Response :: " + JsonResponseinString);




    }

    public static void gettingAllindividualKeys() {
        System.out.println(" ");
        System.out.println(" All Individual keys with values  are");

        Object orderNumber = jsonObject.get("orderNumber");
        System.out.println("orderNumber is " + orderNumber);

       Object versionNumber =  jsonObject.get("versionNumber");
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

}
