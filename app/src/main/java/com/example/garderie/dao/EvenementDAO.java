package com.example.garderie.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.garderie.modele.Evenement;
import com.example.garderie.modele.Utilisateur;

import java.util.ArrayList;
import java.util.List;

public class EvenementDAO extends DAOBase {

    // 1- Declaration des variables
    // 1.1- Pour la création de la table evenement

    public static final String EVENT_TABLE_NAME = "evenements";
    public static final String EVENT_ID = "idevenement";
    public static final String EVENT_CATEGORIE = "categorieevenement";
    public static final String EVENT_TITLE = "titreevenement";
    public static final String EVENT_DESCRIPTION = "descriptionevenement";
    public static final String EVENT_AUTHOR = "parentauteurevenement";


    //---------------------------------------------------------

    // 2- Constructeur de l'Evenement DAO
    public EvenementDAO(Context pcontext) {
        super(pcontext);
    }



    //----------------------------------------------------------------
    //3 - La methode pour Ajouter un evenement à la base de données.
    public void ajouter(Evenement evenement){

        ContentValues value = new ContentValues();
        value.put(EVENT_CATEGORIE,evenement.getCategorieEvenement());
        value.put(EVENT_TITLE,evenement.getTitreEvenement());
        value.put(EVENT_DESCRIPTION,evenement.getDescriptionEvenement());
        value.put(EVENT_AUTHOR,evenement.getParentAuteurEvenement());

        mDb.insert(EVENT_TABLE_NAME,null,value);
    }

    //----------------------------------------------------------------
    //3 - La methode pour compter le nombre de d'evenement total dans la base

    public int compterTousLesEvenements(){
        int compte =0;
        Cursor cursor = mDb.rawQuery("SELECT * FROM evenements ",null);
        compte = cursor.getCount();

        cursor.close();

        return compte;

    }


    //----------------------------------------------------------------
    //3 - La methode pour compter le nombre de d'evenement total dun parent donné.

    public int compterTousLesEvenementsDuParent(String unparent){
        int compte =0;
        Cursor cursor = mDb.rawQuery("SELECT * FROM evenements WHERE parentauteurevenement = ?",new String[]{unparent});
        compte = cursor.getCount();

        cursor.close();

        return compte;

    }


    //----------------------------------------------------------------
    //5 - La methode pour selectionner tous les evenements d'un parent de la base de données.
    public List<Evenement> selectionnerTousLesEvenements(String unparent){

        Evenement evenement=null;
        List<Evenement> listedesevenements =null;

        Cursor cursor = mDb.rawQuery("SELECT * FROM evenements WHERE parentauteurevenement = ?",new String[]{unparent});

        while (cursor.moveToNext()) {

            String categorie = cursor.getString(1);
            String titre = cursor.getString(2);
            String description = cursor.getString(3);
            String auteur = cursor.getString(4);


            evenement = new Evenement(categorie,titre,description,auteur);
            listedesevenements.add(evenement);
        }
        cursor.close();

        return listedesevenements;

    }

    //----------------------------------------------------------------
    //6 - La methode pour selectionner tous les evenements d'un parent de la base de données.
    public ArrayList<String> selectionnerTousLesTitresEvenements(String unparent){

       ArrayList<String> listedestitres =new ArrayList<>();

        Cursor cursor = mDb.rawQuery("SELECT * FROM evenements WHERE parentauteurevenement = ?",new String[]{unparent});

        while (cursor.moveToNext()) {


            String titre = cursor.getString(2);


            listedestitres.add(titre);
        }
        cursor.close();

        return listedestitres;

    }






















}
