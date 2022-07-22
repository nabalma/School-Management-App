package com.example.garderie.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.garderie.R;

import java.util.ArrayList;
import java.util.List;

public class ListeEvenementsActivity extends AppCompatActivity {

    private TextView parentConnectTextView;
    private ListView malisteView;
    private TextView compteEvenementTextView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_evenements);

        parentConnectTextView = findViewById(R.id.idListe_ParentConnect);
        malisteView =findViewById(R.id.idListeEvenement);
        compteEvenementTextView= findViewById(R.id.idCompteEvenement);


        // Affichage de la personne qui est connectée
        Intent intent =getIntent();
        String username = intent.getStringExtra("username");
        parentConnectTextView.setText(username);

        // Affichage de la personne qui est connectée
        int nombredEvenements = intent.getIntExtra("nbredevenements",0);
        compteEvenementTextView.setText(""+nombredEvenements+"");

        // Affichage de la liste des evenements
        ArrayList<String> listeTitres = intent.getStringArrayListExtra("listedesTitres");
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,listeTitres);
        malisteView.setAdapter(arrayAdapter);

    }
}