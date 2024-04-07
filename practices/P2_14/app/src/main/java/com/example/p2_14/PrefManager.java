package com.example.p2_14;
import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    private SharedPreferences pref;
    public PrefManager(Context context){
        this.pref = context.getSharedPreferences("my_app_prefs", Context.MODE_PRIVATE);
    }
    public void saveDefaultTextValue(String text){
        SharedPreferences.Editor editor = this.pref.edit();
        editor.putString("default_text", text);
        editor.apply();
    }
    String getDefaultTextValue(){
        return this.pref.getString("default_text", "");
    }
}
