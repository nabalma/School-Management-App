package com.example.garderie.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.garderie.R;
import com.example.garderie.dao.UtilisateurDAO;
import com.example.garderie.modele.Utilisateur;

public class RegisterActivity extends AppCompatActivity {

    // Declaration des variables

    private EditText nomEditText;
    private EditText prenomEditText;
    private EditText numeroTelephoneEditText;
    private EditText nomUtilisateurEditText;
    private EditText motDePasseEditText;

    private RadioGroup categorieUtilisateurRadioGroup;
    private RadioButton parentRadioButton;
    private RadioButton administrattionRadioButton;
    private RadioButton enseignantRadioButton;

    private Button creerCompteButton;

    private EditText textEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Declaration des variables
        nomEditText = findViewById(R.id.idRegNom);
        prenomEditText = findViewById(R.id.idRegPrenom);
        numeroTelephoneEditText= findViewById(R.id.idRegNumeroTelephone);
        nomUtilisateurEditText= findViewById(R.id.idRegNomUtilisateur);
        motDePasseEditText= findViewById(R.id.idRegMotDePasse);

        categorieUtilisateurRadioGroup = findViewById(R.id.idCategorieUtlisateur);
        parentRadioButton = findViewById(R.id.idRegParent);
        administrattionRadioButton = findViewById(R.id.idRegAdministration);
        enseignantRadioButton = findViewById(R.id.idRegEnseignant);

        creerCompteButton = findViewById(R.id.idRegCreerCompte);





        creerCompteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String categorieUtilisateur;

                //Récupération de la catégorie Utilisateur selon la valeur du bouton radio selectionné

                if (categorieUtilisateurRadioGroup.getCheckedRadioButtonId()==R.id.idRegAdministration)
                {categorieUtilisateur=creerCompteButton.getContext().getString(R.string.registerTypeAdministration_Caption);}
                // L'instruction ci dessous car Je veux aller chercher la valeur dans les Value/String plutot que de le coder en dur

                else if(categorieUtilisateurRadioGroup.getCheckedRadioButtonId()==R.id.idRegEnseignant)
                    {categorieUtilisateur=creerCompteButton.getContext().getString(R.string.registerTypeEnseignant_Caption);}
                    else
                    {categorieUtilisateur=creerCompteButton.getContext().getString(R.string.registerTypeParent_Caption);}

                // Instanciation de l'utilisateur
               Utilisateur utilisateur =new Utilisateur(nomEditText.getText().toString(),prenomEditText.getText().toString(),numeroTelephoneEditText.getText().toString(),nomUtilisateurEditText.getText().toString(),motDePasseEditText.getText().toString(),categorieUtilisateur);

                    //Ajout de l'utilisateur
               UtilisateurDAO utilisateurDAO = new UtilisateurDAO(getApplicationContext());

                // Verifier si l'utilisateur nest pas déja dans la base.
                int compte= utilisateurDAO.countUnUtilisateur(utilisateur.getNomUtilisateur());
                if(compte==0){  // Si l'utilisateur n'existe pas deja dans la base de données, il faut l'ajouter

                    utilisateurDAO.ajouter(utilisateur);

                    // Aller a la page Login , tout en chargeant les credentiels de lutilisateur

                    // Ouverture de lactivité Login et Chargement des données avec les valeurs
                    Intent intentActivity = new Intent(RegisterActivity.this,LoginActivity.class);
                    intentActivity.putExtra("username",utilisateur.getNomUtilisateur());
                    intentActivity.putExtra("password",utilisateur.getMotDePasse());
                    startActivity(intentActivity);
                }
                else {  // Si l'utilisateur existe deja dans la base de données, il faut le signifier par une boite de Dialogue

                    AlertDialog.Builder errorDialog = new AlertDialog.Builder(RegisterActivity.this);

                    errorDialog
                            .setTitle("Echec Création")
                            .setMessage("Désolé ! Un compte existe déja avec ce nom d'utilisateur")
                            .setNegativeButton("OK", null)
                            .show();

                }


            }
        });





    }
}