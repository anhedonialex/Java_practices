package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String server = "https://android-for-students.ru/";
        String serverPath = "/materials/practical/hello.php";
        HashMap<String,String> map = new HashMap<>();
        map.put("name","Bondarew");
        map.put("group", "RIBO-03-22");
        HTTPRunnable hTTPRunnable = new HTTPRunnable(server + serverPath, map);
        Thread th = new Thread(hTTPRunnable);
        th.start();
        try{
            th.join();
        } catch (InterruptedException ex){

        } finally {
            System.out.println(hTTPRunnable.getResponseBody());
            JSONObject jSONobject = new JSONObject(hTTPRunnable.getResponseBody());
            int result = jSONobject.getInt("result_code");
            System.out.println("Result: " + result);
            System.out.println("Type: " + jSONobject.getString("message_type"));
            System.out.println("Text: " + jSONobject.getString("message_text"));
            switch (result){
                case 1:
                    JSONArray jSONArray = jSONobject.getJSONArray("task_list");
                    System.out.println("Task list:");
                    for (int i = 0; i< jSONArray.length();i++){
                        System.out.println((i+1)+") "+jSONArray.get(i));
                    }
                    break;
                case 0:
                    //какая-то обработка исключений
                    break;
                default:
                    break;
            }


        }
    }
}