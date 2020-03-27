package steps.com;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import static jsonfile.com.Tang_gettingallJsonKeys_and_values.*;


public class angg {
    static JSONObject jsonObject;



    @Given("^To Read a \"([^\"]*)\" JSON file$")
    public void toReadAJSONFile(String fileName) throws Throwable {

        parsingTheJson();

    }

    @Then("^To get all keys present in the Json file$")
    public void toGetAllKeysPresentInTheJsonFile() throws IOException, ParseException {
        parsingTheJson();
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
}
