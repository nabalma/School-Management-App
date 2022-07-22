package com.example.garderie.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.garderie.modele.Evenement;
import com.example.garderie.modele.Note;

public class NoteDAO extends DAOBase{

    // 1- Declaration des variables
    // 1.1- Pour la création de la table evenement

    public static final String NOTE_TABLE_NAME = "notes";
    public static final String NOTE_ID = "idnote";
    public static final String GROUPE_ELEVE = "groupeeleve";
    public static final String NOM_PRENOM_ELEVE = "nomprenomeleve";
    public static final String NOTE_ELEVE = "noteeleve";
    public static final String CATEGORIE_NOTE = "categorienote";

    //---------------------------------------------------------

    // 2- Constructeur de l'Evenement DAO
    public NoteDAO(Context pcontext) {
        super(pcontext);
    }

    //----------------------------------------------------------------
    //3 - La methode pour Ajouter une note à la base de données.
    public void ajouter(Note note){

        ContentValues value = new ContentValues();
        value.put(GROUPE_ELEVE,note.getGroupeEleve());
        value.put(NOM_PRENOM_ELEVE,note.getNomPrenomEleve());
        value.put(NOTE_ELEVE,note.getNoteEleve());
        value.put(CATEGORIE_NOTE,note.getCategorieNote());

        mDb.insert(NOTE_TABLE_NAME,null,value);
    }


    //----------------------------------------------------------------
    //4 - La methode pour compter le nombre de note total d'un eleve donné.

    public int compterToutesLesNotesDeleleve(String uneleve){
        int compte =0;
        Cursor cursor = mDb.rawQuery("SELECT * FROM notes WHERE nomprenomeleve = ?",new String[]{uneleve});
        compte = cursor.getCount();

        cursor.close();

        return compte;

    }




}
