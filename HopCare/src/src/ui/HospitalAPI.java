package ui;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Hospital;
import model.HospitalResult;
import model.ListOfResult;
import model.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class HospitalAPI {

    public static ArrayList<Hospital> hospitals = new ArrayList<>();

    public void testAPI() {
        String API_KEY = "AIzaSyCqY6ZWUzNOksYLI0c3FBdOYU4xEDIVorc";
        String findPlaceURL = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=hospitals+in+Vancouver&key=";
        findPlaceURL = findPlaceURL + API_KEY;

        try {

            StringBuilder result = new StringBuilder();
            URL url = new URL(findPlaceURL);
            BufferedReader rd = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();

            String weatherString = result.toString();
            //System.out.println(toPrettyFormat(weatherString));

            Gson gson = new Gson();
            ListOfResult hospital = gson.fromJson(weatherString, ListOfResult.class);


            String PLACES_API_KEY = "AIzaSyCqY6ZWUzNOksYLI0c3FBdOYU4xEDIVorc";

            for (Result IDResults : hospital.results) {

                String ID = IDResults.id;
                String additionalQuery = "https://maps.googleapis.com/maps/api/place/details/json?place_id=";
                additionalQuery = additionalQuery + ID + "&fields=name,rating,vicinity,formatted_phone_number,website,opening_hours&key=" + PLACES_API_KEY;

                StringBuilder resultPlaces = new StringBuilder();
                URL urlPlaces = new URL(additionalQuery);
                BufferedReader rdPlaces = new BufferedReader(new InputStreamReader(urlPlaces.openStream()));

                String linePlaces;
                while ((linePlaces = rdPlaces.readLine()) != null) {
                    resultPlaces.append(linePlaces);
                }
                rd.close();

                String PlacesString = resultPlaces.toString();
                //System.out.println(toPrettyFormat(PlacesString));

                Gson gsonPlace = new Gson();
                HospitalResult hospitalP = gsonPlace.fromJson(PlacesString, HospitalResult.class);
                hospitals.add(hospitalP.result);


            }

            for (Hospital hospital1 : hospitals) {
                System.out.println(hospital1.getName());
                System.out.println("      " + hospital1.getHour());
                System.out.println("      " + hospital1.getAddress());
                System.out.println("      " + hospital1.getRating());
                System.out.println("      " + hospital1.getPhoneNumber());
                System.out.println("      " + hospital1.getWaitingTime() + " minutes");
                System.out.println("      " + hospital1.getWebsite());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String toPrettyFormat(String jsonString) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(jsonString).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(json);

        return prettyJson;
    }


}
