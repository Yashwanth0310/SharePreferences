package com.example.sharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.sharepreferences", Context.MODE_PRIVATE);
        /*
        ArrayList<String> friends = new ArrayList<>();
        friends.add("Jon");
        friends.add("Robb");
        friends.add("Sansa");
        friends.add("Bran");
        friends.add("Arya");
        friends.add("Rickon");
        try {
            sharedPreferences.edit().putString("Friends", ObjectSerializer.serialize(friends)).apply();
            Log.i("Friends",ObjectSerializer.serialize(friends));
        }
        catch (Exception e){
            e.printStackTrace();
        }
         */
        ArrayList<String> newFriends = new ArrayList<>();
        try {
            newFriends = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("Friends",ObjectSerializer.serialize(new ArrayList<String>())));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("newFriends",newFriends.toString());
        // sharedPreferences.edit().putString("username","Yashwanth G").apply();
        // String username = sharedPreferences.getString("username","");
        // Log.i("Username",username);
    }
}