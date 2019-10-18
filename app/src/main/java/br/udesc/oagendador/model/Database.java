package br.udesc.oagendador.model;

import android.util.Log;

import com.google.firebase.database.FirebaseDatabase;

public class Database {
    private static Database instance;

    private Database() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        Log.d("Database", "Database: "+ database.getReference().getRoot().getKey());
    }
    public static Database getInstance() {
        if(instance == null) instance = new Database();
        return instance;
    }
}
