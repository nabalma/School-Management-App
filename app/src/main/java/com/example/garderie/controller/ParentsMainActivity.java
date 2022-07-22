package com.example.garderie.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.garderie.R;
import com.example.garderie.dao.EvenementDAO;
import com.example.garderie.dao.UtilisateurDAO;
import com.example.garderie.modele.Evenement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ParentsMainActivity extends AppCompatActivity {

    private TextView idParentconnectTexView;
    private Button continuerDeclarationButton;
    private RadioGroup categorieEvenementRadioGroup;
    private Button genererListeEvenementButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parents_main);

        idParentconnectTexView=findViewById(R.id.idParentConnect);
        continuerDeclarationButton=findViewById(R.id.idContinuezDeclaration);
        categorieEvenementRadioGroup = findViewById(R.id.idCategorieEvenement);
        genererListeEvenementButton = findViewById(R.id.idgenererListe);


        // Affichage de la personne qui est connectée
        Intent intent =getIntent();
        String username = intent.getStringExtra("username");
        idParentconnectTexView.setText(username);

        // Affichage d'un Toast de bienvenu
        Toast.makeText(getApplicationContext(),"Bienvenu (e) à la garderie !  "+username,Toast.LENGTH_LONG).show();

        // Gestion du clic sur le bouton "Continuer la Déclaration"
            continuerDeclarationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Recuperation de la categorie d'evenement (selon le type coché par le client)
                String categorieEvenement=continuerDeclarationButton.getContext().getString(R.string.absence);  // Par défaut, l'évenement Absence sera affichée

                if (categorieEvenementRadioGroup.getCheckedRadioButtonId()==R.id.idDeclarerBlessure)
                {categorieEvenement=continuerDeclarationButton.getContext().getString(R.string.blessure);}

                if (categorieEvenementRadioGroup.getCheckedRadioButtonId()==R.id.idSignalerAnniversaire)
                {categorieEvenement=continuerDeclarationButton.getContext().getString(R.string.anniversaire);}

                if (categorieEvenementRadioGroup.getCheckedRadioButtonId()==R.id.idSignalerAutreEvenement)
                {categorieEvenement=continuerDeclarationButton.getContext().getString(R.string.autre_evenement);}


                // Ouverture du formulaire de déclaration
                Intent intentActivity = new Intent(ParentsMainActivity.this,ParentDeclarationActivity.class);
                intentActivity.putExtra("username",username);
                intentActivity.putExtra("categorie",categorieEvenement);
                startActivity(intentActivity);

            }
        });


        // Gestion du clic sur le bouton "Generer"
        genererListeEvenementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Execution de la requete de generation des evenements
                EvenementDAO evenementDAO = new EvenementDAO(getApplicationContext());
                ArrayList<String> listedesTitres;
                listedesTitres = evenementDAO.selectionnerTousLesTitresEvenements(username);

                // Execution de la requete de dénombrement des evenements
                int compteEvenement;
                compteEvenement = evenementDAO.compterTousLesEvenementsDuParent(username);

                // Ouverture du formulaire de déclaration
                Intent intentActivity = new Intent(ParentsMainActivity.this,ListeEvenementsActivity.class);
                intentActivity.putExtra("username",username);
                intentActivity.putStringArrayListExtra("listedesTitres",listedesTitres);
                intentActivity.putExtra("nbredevenements",compteEvenement);
                startActivity(intentActivity);

            }
        });
















    }





}