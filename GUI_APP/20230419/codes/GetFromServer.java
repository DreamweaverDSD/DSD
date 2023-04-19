package com.example.dsd_android;

import java.util.ArrayList;

public class GetFromServer {
    public ArrayList<DataMotion> getdatalist(){
        ArrayList<DataMotion> dataMotionArrayList = new ArrayList<DataMotion>();
        for(int i = 0; i < 30; i ++) {
            dataMotionArrayList.add(new DataMotion(0, 1681627570235L));
            dataMotionArrayList.add(new DataMotion(3, 1681628570303L));
            dataMotionArrayList.add(new DataMotion(6, 1681630570689L));
        }
        return dataMotionArrayList;
    }

    public int discarddata(int datalist_id){
        return 0;
    }
    public int changedatalabel(int datalist_id, int type){
        return 0;
    }
}
