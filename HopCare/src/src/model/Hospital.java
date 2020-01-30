package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class Hospital {

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("vicinity")
    @Expose
    public String address;

    @SerializedName("opening_hours")
    @Expose
    public Hour hour;

    @SerializedName("rating")
    @Expose
    public double rating;

    public double waitingTime;

    @SerializedName("website")
    @Expose
    public URL website;


    @SerializedName("formatted_phone_number")
    @Expose
    public String phoneNumber;

    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }

    public Boolean getHour() {
        if(hour == null){
            return false;
        } else {
            return hour.open;
        }

    }

    public double getRating() {
        return rating;
    }

    public double getWaitingTime() {
        Random rand = new Random();
        double waitingTime = rand.nextInt(60 - 30) + 30;
        return waitingTime;
    }

    public URL getWebsite() throws MalformedURLException {
        if(website == null){
            String nameTemp = name;
            name = name.replace(" ", "+");
            name = name.replace("'", "");
            return new URL("https://google.com/search?q="+name);
        } else {
            return website;
        }
    }

    public String getPhoneNumber() {
        if(phoneNumber == null){
            return "Phone Number Unavailable";
        } else {
            return phoneNumber;
        }
    }

    @Override
    public String toString() {
        return "• Hospital Name: " + name +
                "\n• Address: " + address +
                "\n• Phone Number: " + phoneNumber +
                "\n• Wait Time: " + waitingTime;
           //    "\n• Name: '" + name + '\'';
    }


}
