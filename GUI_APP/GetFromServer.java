package com.example.dsd_android;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import javax.net.ssl.HttpsURLConnection;

public class GetFromServer {
    static String server_url = "http://139.155.89.85:11451";//must have "http://" !!!
    //static String server_port = "11451";
    public String result;
    final String errMsg = "Connection error";
    static public File dir;
    private String post(String urlStr, JSONObject json) throws Exception
    {
        String jsonStr = JSON.toJSONString(json);
        HttpURLConnection httpConn = null;
        OutputStream os = null;
        InputStream is = null;
        BufferedReader br = null;
        String responseStr;
        try{
            URL url = new URL(urlStr);
            httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestMethod("POST");
            httpConn.setRequestProperty("Accept", "application/json");
            httpConn.setDoOutput(true);
            os = httpConn.getOutputStream();
            os.write(jsonStr.getBytes());
            if(httpConn.getResponseCode() == 200)
            {
                is = httpConn.getInputStream();
                br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                StringBuilder sbf = new StringBuilder();
                String temp;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                responseStr = sbf.toString();
            }
            else
            {
                responseStr = errMsg;
            }
        }catch(Exception e) {
            e.printStackTrace();
            throw e;
        }finally {
            if(br != null)
            {
                try{
                    br.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(httpConn != null)
                httpConn.disconnect();
        }
        return responseStr;
    }

    //the ID of user is stored locally
    private String getUserID() {
        String name = "";
        try{
            Reader reader = new FileReader(dir);
            int len = 0;
            char b[] = new char[1024];
            int temp = 0;
            while((temp = reader.read()) != -1){
                b[len] = (char)temp;
                len++;
            }
            reader.close();
            name = new String(b, 0, len);
        }catch(Exception e){
            e.printStackTrace();
        }
        //System.out.println("用户名：" + name);
        return name;
    }
    public int register(ArrayList<String> strings){
        //okhttp.setRetryOnConnectionFailure(true);
        JSONObject json = new JSONObject();
        json.put("type", "Register");
        json.put("username", strings.get(0));
        json.put("password", strings.get(1));
        json.put("birthday", strings.get(3));
        json.put("phoneNumber", strings.get(4));
        json.put("email", strings.get(5));
        try{
            String response = post(server_url, json);
            System.out.println(response);
            if(response.equals(errMsg))
                return -1;
            if(JSON.parseObject(response).get("message").equals("RegisterSucceed"))
                return 0;
        }catch (Exception e){
            return -1;
        }
        return -1;
    }
    public int login(String username, String password){
        JSONObject json = new JSONObject();
        json.put("type", "Login");
        json.put("id", username);
        json.put("password", password);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(dir);
            fos.write(username.getBytes());
            fos.close();
            System.out.println("file created!");
            String response = post(server_url, json);
            JSONObject rJson = JSON.parseObject(response);
            if(rJson.get("message").equals("LoginSucceed"))
                return 0;
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int connectequip(String IP_address, int IP_port)
    {
        JSONObject json = new JSONObject();
        json.put("type", "ConnectEquipment");
        // the type of equipment?
        json.put("id", getUserID());
        json.put("ip", IP_address);
        json.put("port", IP_port);
        String response;
        try{
            response = post(server_url, json);
        }catch(Exception e){
            return -1;
        }
        JSONObject rJson = JSON.parseObject(response);
        if(rJson.get("message").toString().equals("ConnectEquipmentSucceed"))
            return 0;
        return -1;
    }
    public int unbindequip()
    {
        JSONObject json = new JSONObject();
        json.put("type", "DisconnectEquipment");
        json.put("id", getUserID());
        String response;
        try{
            response = post(server_url, json);
        }catch(Exception e){
            return -1;
        }
        JSONObject rJson = JSON.parseObject(response);
        if(rJson.get("message").toString().equals("DisconnectEquipmentResponse"))
            return 0;
        return -1;
    }
    public int setuserinfo(ArrayList<String> userinfo)
    {
        JSONObject json = new JSONObject();
        json.put("type", "ChangeUserInfo");
        json.put("id", getUserID());
        json.put("birthday", userinfo.get(0));
        json.put("phoneNumber", userinfo.get(1));
        json.put("email", userinfo.get(2));
        String response;
        try{
            response = post(server_url, json);
        }catch(Exception e){
            return -1;
        }
        JSONObject rJson = JSON.parseObject(response);
        if(rJson.get("message").toString().equals("ChangeUserInfoSucceed"))
            return 0;
        return -1;
    }
    public ArrayList<DataMotion> getdatalist(){
        JSONObject json = new JSONObject();
        json.put("type", "GetData");
        json.put("account", getUserID());
        ArrayList<DataMotion> dataMotionArrayList;
        String response;
        try{
            response = post(server_url, json);
            dataMotionArrayList = new ArrayList<>();
            JSONArray motionHistory = JSONObject.parseArray(response);
            for(Object history:motionHistory)
            {
                JSONObject JSONobj = (JSONObject)history;
                int dt = Integer.parseInt(JSONobj.get("typeOfMotion").toString());
                long st = Long.parseLong(JSONobj.get("start time").toString());
                long dur = Long.parseLong(JSONobj.get("duration").toString());
                dataMotionArrayList.add(new DataMotion(dt, st, dur));
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return dataMotionArrayList;
    }

    public int discarddata(int datalist_id){
        JSONObject json = new JSONObject();
        json.put("type", "DiscardData");
        json.put("id", getUserID());
        json.put("startTime", datalist_id);
        String response;
        try{
            response = post(server_url, json);
        }catch(Exception e){
            return -1;
        }
        JSONObject rJson = JSON.parseObject(response);
        if(rJson.get("message").toString().equals("DiscardDataSucceed"))
            return 0;
        return -1;
    }
    public int changedatalabel(int datalist_id, int type){
        JSONObject json = new JSONObject();
        json.put("type", "ChangeLabel");
        json.put("id", getUserID());
        json.put("startTime", datalist_id);
        json.put("label", type);
        String response;
        try{
            response = post(server_url, json);
        }catch(Exception e){
            return -1;
        }
        JSONObject rJson = JSON.parseObject(response);
        if(rJson.get("message").toString().equals("ChangeLabelSucceed"))
            return 0;
        return -1;
    }
    public int collectdata_start(int type){
        JSONObject json = new JSONObject();
        json.put("type", "CollectData");
        json.put("id", getUserID());
        json.put("label", type);
        String response;
        try{
            response = post(server_url, json);
        }catch(Exception e){
            return -1;
        }
        JSONObject rJson = JSON.parseObject(response);
        if(rJson.get("message").toString().equals("CollectDataSucceed"))
            return 0;
        return -1;
    }
    public int collectdata_end(int type){
        JSONObject json = new JSONObject();
        json.put("type", "CollectDataStop");
        json.put("id", getUserID());
        String response;
        try{
            response = post(server_url, json);
        }catch(Exception e){
            return -1;
        }
        JSONObject rJson = JSON.parseObject(response);
        if(rJson.get("message").toString().equals("CollectDataStopSucceed"))
            return 0;
        return -1;
    }
    public ArrayList<String> getequipinfo(){
        ArrayList<String> equipinfo = new ArrayList<>();
        JSONObject json = new JSONObject();
        json.put("type", "GetSensorDetails");
        try{
            String response = post(server_url, json);
            JSONObject responseJson = JSONObject.parseObject(response);
            System.out.println(responseJson.get("type"));
            JSONObject info;
            info = responseJson.getJSONObject("L1");
            equipinfo.add(info.get("name").toString());
            equipinfo.add(info.get("macAddr").toString());
            info = responseJson.getJSONObject("L2");
            equipinfo.add(info.get("name").toString());
            equipinfo.add(info.get("macAddr").toString());
            info = responseJson.getJSONObject("L3");
            equipinfo.add(info.get("name").toString());
            equipinfo.add(info.get("macAddr").toString());
            info = responseJson.getJSONObject("R1");
            equipinfo.add(info.get("name").toString());
            equipinfo.add(info.get("macAddr").toString());
            info = responseJson.getJSONObject("R2");
            equipinfo.add(info.get("name").toString());
            equipinfo.add(info.get("macAddr").toString());
            info = responseJson.getJSONObject("R3");
            equipinfo.add(info.get("name").toString());
            equipinfo.add(info.get("macAddr").toString());
        } catch(Exception e){
            for(int i = 0; i < 12; i++)
                equipinfo.add("error");
            e.printStackTrace();
        }
        return equipinfo;
    }
    public ArrayList<String> getequipstatus(){
        ArrayList<String> equipstatus = new ArrayList<String>();
        JSONObject json = new JSONObject();
        json.put("type", "GetSensorStatus");
        try{
            String response = post(server_url, json);
            JSONObject responseJson = JSONObject.parseObject(response);
            JSONObject status = responseJson.getJSONObject("L1");
            equipstatus.add(status.get("connect").toString());
            equipstatus.add(status.get("battery").toString());
            status = responseJson.getJSONObject("L2");
            equipstatus.add(status.get("connect").toString());
            equipstatus.add(status.get("battery").toString());
            status = responseJson.getJSONObject("L3");
            equipstatus.add(status.get("connect").toString());
            equipstatus.add(status.get("battery").toString());
            status = responseJson.getJSONObject("R1");
            equipstatus.add(status.get("connect").toString());
            equipstatus.add(status.get("battery").toString());
            status = responseJson.getJSONObject("R2");
            equipstatus.add(status.get("connect").toString());
            equipstatus.add(status.get("battery").toString());
            status = responseJson.getJSONObject("R3");
            equipstatus.add(status.get("connect").toString());
            equipstatus.add(status.get("battery").toString());
            System.out.println(responseJson.get("type"));
        }catch (Exception e){

        }
        return equipstatus;
    }
    public int resetmodel(){
        JSONObject json = new JSONObject();
        json.put("type", "ResetModel");
        json.put("account", getUserID());
        //String response = post(server_url, json);
        return 0;
    }
    public ArrayList<String> showmodelinfo(){
        JSONObject json = new JSONObject();
        json.put("type", "GetModelInfo");
        json.put("account", getUserID());
        //String response = post(server_url, json);
        //JSONObject info = JSONObject.parseObject(response);
        ArrayList<String> modelinfo = new ArrayList<String>();
        //modelinfo.add(info.get("modeltype").toString());//whether the model is generalized or not
        //modelinfo.add(info.get("accurate").toString());
        return modelinfo;
    }
}
