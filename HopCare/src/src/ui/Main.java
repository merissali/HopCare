package ui;

import model.Hospital;

import java.net.MalformedURLException;

import static ui.HospitalAPI.hospitals;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        HospitalAPI hospitalAPI = new HospitalAPI();
        hospitalAPI.testAPI();
        for (Hospital hospital1 : hospitals) {
            System.out.println(hospital1.getName());
            System.out.println("      " + hospital1.getHour());
            System.out.println("      " + hospital1.getAddress());
            System.out.println("      " + hospital1.getRating());
            System.out.println("      " + hospital1.getPhoneNumber());
            System.out.println("      " + hospital1.getWaitingTime() + " minutes");
            System.out.println("      " + hospital1.getWebsite());

        }
    }
}
