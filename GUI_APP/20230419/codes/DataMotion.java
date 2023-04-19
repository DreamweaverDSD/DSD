package com.example.dsd_android;

public class DataMotion {
    Long starttime;
    int datatype;


    public DataMotion(int dt, Long st){
        starttime = st;
        datatype = dt;
    }
    public String checktype(){
        String string = new String();
        if(datatype == 0){
            string = "Sit";
        }
        else if(datatype == 1){
            string = "Stand";
        }
        else if(datatype == 2){
            string = "Go straight";
        }
        else if(datatype == 3){
            string = "Go uphill/upstairs";
        }
        else if(datatype == 4){
            string = "Go downhill/downstairs";
        }
        else if(datatype == 5){
            string = "Go left";
        }
        else if(datatype == 6){
            string = "Go right";
        }
        else{
            string = "Error";
        }
        return string;
    }
}
