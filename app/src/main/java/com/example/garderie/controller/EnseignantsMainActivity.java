package com.example.garderie.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.garderie.R;
import com.example.garderie.dao.NoteDAO;
import com.example.garderie.modele.Note;

public class EnseignantsMainActivity extends AppCompatActivity {

    private TextView idEnseignantconnectTexView;
    private EditText groupeEleveEditText;
    private EditText nomPrenomEleveEditText;
    private EditText noteEleveEditText;
    private RadioGroup categorieNoteRadioGroup;
    private Button enregistrerNoteButton;
    private TextView compteNotesTexView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enseignants_main);

        idEnseignantconnectTexView=findViewById(R.id.idEnseignantConnect);
        groupeEleveEditText = findViewById(R.id.idEnsGroupeEleve);
        nomPrenomEleveEditText = findViewById(R.id.idEnsNomEtPrenomEleve);
        noteEleveEditText = findViewById(R.id.idEnsNoteEleve);
        categorieNoteRadioGroup = findViewById(R.id.idCategorieEvenement);
        enregistrerNoteButton = findViewById(R.id.idensEnregistrerNote);
        compteNotesTexView =findViewById(R.id.idCompteNotes);

        // Affichage de la personne qui est connectée
        Intent intent =getIntent();
        String username = intent.getStringExtra("username");
        idEnseignantconnectTexView.setText(username);


        // Affichage d'un Toast de bienvenu
        Toast.makeText(getApplicationContext(),"Bienvenu (e) à la garderie !  "+username,Toast.LENGTH_LONG).show();

        // Gestion du click sur le bouton "Enregistrer Note"
        enregistrerNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Recuperation de la categorie de la note
                String categorieNote=enregistrerNoteButton.getContext().getString(R.string.quiz_Caption);  // Par défaut, la note est un quiz de 10%

                if (categorieNoteRadioGroup.getCheckedRadioButtonId()==R.id.idIntra)
                {categorieNote=enregistrerNoteButton.getContext().getString(R.string.intra_Caption);;}

                if (categorieNoteRadioGroup.getCheckedRadioButtonId()==R.id.idFinale)
                {categorieNote=enregistrerNoteButton.getContext().getString(R.string.final_Caption);;}

                // Instantiation de la note
                Note note = new Note(groupeEleveEditText.getText().toString(),nomPrenomEleveEditText.getText().toString(),Integer.parseInt(noteEleveEditText.getText().toString()),categorieNote);

                //Ajout de la note a la base de données
                NoteDAO noteDAO = new NoteDAO(getApplicationContext());
                noteDAO.ajouter(note);

                //Ajout de la note a la base de données
                int compte = noteDAO.compterToutesLesNotesDeleleve(nomPrenomEleveEditText.getText().toString());
                compteNotesTexView.setText(" "+compte+" ");
            }
        });







    }
}