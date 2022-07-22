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
import com.example.garderie.dao.UtilisateurDAO;
import com.example.garderie.modele.Utilisateur;

public class LoginActivity extends AppCompatActivity {


// Déclaration des variables
private EditText nomUtilisateurEditText;
private EditText motdepasseEditText;
private Button connectezVousButton;
private TextView allerARegisterTextView;











    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

// Référencement des variables
        nomUtilisateurEditText=findViewById(R.id.idLoginUserName);
        motdepasseEditText=findViewById(R.id.idLoginPassword);
        connectezVousButton = findViewById(R.id.idloginconnexion);
        allerARegisterTextView = findViewById(R.id.idAllerARegister);

// Aller a Register en cliquant sur le texte Vous êtes Nouveau ?
  allerARegisterTextView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

          // Redirection vers Register
          Intent intentActivity = new Intent(LoginActivity.this, RegisterActivity.class);
          startActivity(intentActivity);

      }
  });

        // Récuperation des valeurs du username et login venant du register activity
        Intent intent =getIntent();
        String nomUtilisateur = intent.getStringExtra("username");
        String motdepasse = intent.getStringExtra("password");

        nomUtilisateurEditText.setText(nomUtilisateur);
        motdepasseEditText.setText(motdepasse);



// Connection si appui sur le bouton
  connectezVousButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          UtilisateurDAO utilisateurDAO = new UtilisateurDAO(getApplicationContext());
         Utilisateur utilisateur= utilisateurDAO.getUtilisateur(nomUtilisateurEditText.getText().toString(),motdepasseEditText.getText().toString());

          if (utilisateur != null) {

              if(utilisateur.getCategorieUtilisateur().equals(getApplicationContext().getString(R.string.registerTypeParent_Caption))){
                  Intent intentActivity = new Intent(LoginActivity.this, ParentsMainActivity.class);
                  intentActivity.putExtra("username",utilisateur.getNomUtilisateur());
                  startActivity(intentActivity);
              }
              else  if(utilisateur.getCategorieUtilisateur().equals(getApplicationContext().getString(R.string.registerTypeEnseignant_Caption))){
                  Intent intentActivity = new Intent(LoginActivity.this, EnseignantsMainActivity.class);
                  intentActivity.putExtra("username",utilisateur.getNomUtilisateur());
                  startActivity(intentActivity);
              }
              else  if(utilisateur.getCategorieUtilisateur().equals(getApplicationContext().getString(R.string.registerTypeAdministration_Caption))){
                  Intent intentActivity = new Intent(LoginActivity.this, AdministrationMainActivity.class);
                  intentActivity.putExtra("username",utilisateur.getNomUtilisateur());
                  startActivity(intentActivity);
              }


          } else {
              AlertDialog.Builder errorDialog = new AlertDialog.Builder(connectezVousButton.getContext());

              errorDialog
                      .setTitle("Echec connexion")
                      .setMessage("Erreur email ou mot de passe incorrect")
                      .setNegativeButton("OK", null)
                      .show();
          }




         }


  });















    }
}