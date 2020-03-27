package steps.com;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

import static jsonfile.com.TangJsonUtils.*;


public class TangJsonSteps {

    public static final Logger log = Logger.getLogger("murthyLogger");

    @Given("^To Read a \"([^\"]*)\" JSON file$")
    public void toReadAJSONFile(String fileName) throws Throwable {

        parsingTheJson();
        log.info("Parsed the json file");

    }

    @Then("^To get all keys present in the Json file$")
    public void toGetAllKeysPresentInTheJsonFile() throws IOException, ParseException {

        Set all_Keys = jsonObject.keySet();
        int total_keys_in_jsonFile = all_Keys.size();
        System.out.println("Total Keys In JsonFile are::  " + total_keys_in_jsonFile);
        Iterator all_Keys_ite = all_Keys.iterator();
        System.out.println("Keys of complete Json File are :: ");
        while (all_Keys_ite.hasNext()) {
            System.out.print(all_Keys_ite.next());
            System.out.println(" ");

        }
    }

    @Then("^To get a value of \"([^\"]*)\" key$")
    public void toGetAValueOfKey(Object givenKey) {

        Object valueofGivenKey = jsonObject.get(givenKey);
        System.out.println("value of Given Key is :: " + valueofGivenKey);


    }

    @Then("^To retrieve the Json Object of \"([^\"]*)\" key$")
    public void toRetrieveTheJsonObjectOfKey(String givenObject) {

        JSONObject valueofGivenObject = (JSONObject) jsonObject.get(givenObject);
        System.out.println("value of Given Object is  :: " + valueofGivenObject);

    }

    @And("^To retrieve the Json Array of \"([^\"]*)\" key$")
    public void toRetrieveTheJsonArrayOfKey(String givenArray) {

        JSONArray valueofGivenArray = (JSONArray) jsonObject.get(givenArray);
        System.out.println("value of Given Array is :: " + valueofGivenArray);

    }

    @Then("^To get first individual keys in json file$")
    public void toGetFirstIndividualKeysInJsonFile() {

        gettingAllindividualKeys();
    }

    @Then("^To get the value of all keys present in json file$")
    public void toGetTheValueOfAllKeysPresentInJsonFile() {

        gettingAllvaluesByKeys();
    }

    @Then("^To get all the data from existing objects in json file$")
    public void toGetAllTheDataFromExistingObjectsInJsonFile() {
        String sourceInfo = jsonObject.get("sourceInfo").toString();
        System.out.println("sourceInfo is " + sourceInfo);
        String orderTotal = jsonObject.get("paymentDetails").toString();
        System.out.println("orderTotal is " + orderTotal);
        String customer = jsonObject.get("customer").toString();
        System.out.println("customer is " + customer);
    }

    @Then("^To get all the data from existing arrays in json file$")
    public void toGetAllTheDataFromExistingArraysInJsonFile() {
        JSONArray paymentDetails_jsonArray = (JSONArray) jsonObject.get("paymentDetails");
        System.out.println("");
        System.out.println("paymentDetails: ");
        //Iterating the contents of the array
        for (Object item : paymentDetails_jsonArray) {
            System.out.print(item);
        }

        JSONArray subOrders_jsonArray = (JSONArray) jsonObject.get("subOrders");
        System.out.println("");
        System.out.println("subOrders details: ");
        //Iterating the contents of the array
        for (Object value : subOrders_jsonArray) {
            System.out.print(value);
        }

        JSONObject cut = (JSONObject) jsonObject.get("orderTotal");

        Set cuts = cut.keySet();
        for (Object o : cuts) {
            System.out.print(o);
        }


    }

    @When("^To retrieve the Json Array of sourceInfo key only$")
    public void toRetrieveTheJsonArrayOfSourceInfoKeyOnly() {

        JSONObject valueofsourceInfo = (JSONObject) jsonObject.get("sourceInfo");
        System.out.println("value of Given parent key  is  :: " + valueofsourceInfo);

        String source = (String) valueofsourceInfo.get("source");
        System.out.println("Value of Child key value is " + source);
    }


    @When("^To retrieve the Json for the given key \"([^\"]*)\" and child key \"([^\"]*)\"$")
    public void toRetrieveTheJsonForTheGivenKeyAndChildKey(String parentKey, String childKey) throws Throwable {
        JSONObject dataofParentKey = (JSONObject) jsonObject.get(parentKey);
        System.out.println("value of Given " + parentKey + " parent key  is  :: " + dataofParentKey);

        Object childkeyValue = dataofParentKey.get(childKey);
        System.out.println("Value of Child key " + childKey + " is " + childkeyValue);
    }
}
