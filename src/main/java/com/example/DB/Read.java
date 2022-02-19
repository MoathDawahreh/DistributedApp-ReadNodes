package com.example.DB;

import com.example.Models.Company;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class Read {

    private ConcurrentHashMap<String, Company> concurrentHashMaphashMap = new ConcurrentHashMap<>();

    public JSONArray read() {
        JSONParser jsonParser = new JSONParser();
        JSONArray CompaniesList = new JSONArray();
        try (FileReader reader = new FileReader("C:\\Users\\moath\\Desktop\\Database\\Companies.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            CompaniesList = (JSONArray) obj;
            //System.out.println(CompaniesList);

            //Iterate over companies array
            CompaniesList.forEach(emp -> parseEmployeeObject((JSONObject) emp));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return CompaniesList;
    }

    private void parseEmployeeObject(JSONObject employee) {
        JSONObject employeeObject = (JSONObject) employee.get("company");

        String companyName = (String) employeeObject.get("companyName");

        String NumberOfStaff = (String) employeeObject.get("NumberOfStaff");

        String website = (String) employeeObject.get("website");

        Company company = new Company(companyName, NumberOfStaff, website);
        // System.out.println(company);
        concurrentHashMaphashMap.put(companyName, company);

    }


}
