package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ListOfHospitals {
    @SerializedName("results")
    @Expose
    public List<Hospital> hospitals;

}
