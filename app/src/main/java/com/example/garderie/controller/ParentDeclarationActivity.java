package com.example.garderie.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.garderie.R;
import com.example.garderie.dao.EvenementDAO;
import com.example.garderie.dao.UtilisateurDAO;
import com.example.garderie.modele.Evenement;
import com.example.garderie.modele.Utilisateur;

public class ParentDeclarationActivity extends AppCompatActivity {
    private TextView parentConnectTextView;
    private TextView categorieEvenementTextView;
    private EditText titreEvenementEditText;
    private EditText descriptionEvenementEditText;
    private Button soumettreEvenementButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_declaration);

        parentConnectTextView =findViewById(R.id.idDeclParentConnect);
        categorieEvenementTextView =findViewById(R.id.idDeclParentCategorie);
        titreEvenementEditText = findViewById(R.id.idDeclParentTitre);
        descriptionEvenementEditText = findViewById(R.id.idDeclParentDescription);
        soumettreEvenementButton=findViewById(R.id.idDeclParentSoumettre);


        // Affichage de la personne qui est connectée
        Intent intent =getIntent();
        String username = intent.getStringExtra("username");
        parentConnectTextView.setText(username);


        // Affichage de la catégorie qui a été selectionnée dans la precedente vue

        String categorie = intent.getStringExtra("categorie");
        categorieEvenementTextView.setText(categorie);


        // Soumission du formulaire
        soumettreEvenementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Instanciation de l'évenement
                Evenement evenement =new Evenement(categorie,titreEvenementEditText.getText().toString(),descriptionEvenementEditText.getText().toString(),username);

                //Ajout de l'évenement dans la base de données
                EvenementDAO evenementDAO = new EvenementDAO(getApplicationContext());
                evenementDAO.ajouter(evenement);

                //Message de Confirmation de l'Ajout de l'évenement dans la base de données

                AlertDialog.Builder errorDialog = new AlertDialog.Builder(soumettreEvenementButton.getContext());

                errorDialog
                        .setTitle("Confirmation d'ajout d'évènement")
                        .setMessage("Félicitattion, Votre évenement a bien été ajouté ! ")
                        .setNegativeButton("OK", null)
                        .show();

            }
        });

    }
}