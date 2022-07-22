package com.example.garderie.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.garderie.R;
import com.example.garderie.dao.UtilisateurDAO;
import com.example.garderie.modele.Utilisateur;

import java.util.ArrayList;

public class AdministrationMainActivity extends AppCompatActivity {

    private TextView idAdminconnectTexView;
    private TextView listeParentsTextView;
    private TextView listeEnseignantsTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administration_main);

        idAdminconnectTexView=findViewById(R.id.idAdminConnect);
        listeParentsTextView=findViewById(R.id.idEditerListeParents);
        listeEnseignantsTextView=findViewById(R.id.idEditerListeEnseignants);


        // Affichage de la personne qui est connectée

        Intent intent =getIntent();
        String username = intent.getStringExtra("username");
        idAdminconnectTexView.setText(username);

        // Affichage d'un Toast de bienvenu
        Toast.makeText(getApplicationContext(),"Bienvenu (e) à la garderie !  "+username,Toast.LENGTH_LONG).show();

//--------------------------------------------------------------------------------------------------
        // Gestion du bouton "Liste des parents"
        listeParentsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentActivity = new Intent(listeParentsTextView.getContext(), AdminListesActivity.class);
                intentActivity.putExtra("nomlisteparent",listeParentsTextView.getContext().getString(R.string.liste_parents));
                intentActivity.putExtra("username",username);
                startActivity(intentActivity);



            }
        });

//--------------------------------------------------------------------------------------------------
        // Gestion du bouton "Liste des Enseignants"
        listeEnseignantsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentActivity = new Intent(listeParentsTextView.getContext(), AdminListesActivity.class);
                intentActivity.putExtra("nomlisteprofesseur",listeParentsTextView.getContext().getString(R.string.liste_professeurs));
                intentActivity.putExtra("username",username);
                startActivity(intentActivity);
            }
        });



    }
}