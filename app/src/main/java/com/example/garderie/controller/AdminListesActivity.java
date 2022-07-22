package com.example.garderie.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.garderie.R;
import com.example.garderie.dao.UtilisateurDAO;
import com.example.garderie.modele.ListEnseignantsAdapter;
import com.example.garderie.modele.ListParentsAdapter;
import com.example.garderie.modele.Utilisateur;

import java.util.ArrayList;

public class AdminListesActivity extends AppCompatActivity {

    private TextView listeAdminConnectTextView;
    private TextView captionListeTextView;
    private TextView nomListeTextView;
    private ListView listeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_listes);


        captionListeTextView=findViewById(R.id.idlistecaption);
        nomListeTextView=findViewById(R.id.idnomliste);
        listeListView = findViewById(R.id.idListe);
        listeAdminConnectTextView =findViewById(R.id.idListe_AdminConnect);


        // Affichage de la personne qui est connectée
        Intent intentConnect =getIntent();
        String username = intentConnect.getStringExtra("username");
        listeAdminConnectTextView.setText(username);


        Intent intent = getIntent();

        if(intent.getStringExtra("nomlisteparent")!=null){
            String nomListe = intent.getStringExtra("nomlisteparent");
            nomListeTextView.setText(nomListe);

            // Execution de la requete et Affichage de la liste des parents

            // **** Execution de la requete ***
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(getApplicationContext());
         ArrayList<Utilisateur> listeParents = utilisateurDAO.selectionnerTousLesUtilisateurs("Parent");

          // **** Affichage de la liste ***
           ListParentsAdapter adapter = new ListParentsAdapter(getApplicationContext(),R.layout.list_view_single_row,listeParents);
           listeListView .setAdapter(adapter);


        }
        else{
            String nomListe = intent.getStringExtra("nomlisteprofesseur");
            nomListeTextView.setText(nomListe);

            // Execution de la requete et Affichage de la liste des parents

            // **** Execution de la requete ***
            UtilisateurDAO utilisateurDAO = new UtilisateurDAO(getApplicationContext());
            ArrayList<Utilisateur> listeEnseignants = utilisateurDAO.selectionnerTousLesUtilisateurs("Enseignant");

            // **** Affichage de la liste ***
            ListEnseignantsAdapter adapter = new ListEnseignantsAdapter(getApplicationContext(),R.layout.list_view_single_row,listeEnseignants);
            listeListView .setAdapter(adapter);


        }



    }
}