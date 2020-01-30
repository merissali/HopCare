package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hour {

    @SerializedName("open_now")
    @Expose
    public Boolean open;

    public Hour(Boolean bool){
        open = bool;
    }
}
