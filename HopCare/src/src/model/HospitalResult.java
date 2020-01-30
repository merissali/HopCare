package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HospitalResult {

    @SerializedName("result")
    @Expose
    public Hospital result;
}
