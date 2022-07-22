package com.example.garderie.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.garderie.modele.Evenement;
import com.example.garderie.modele.Utilisateur;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAO extends DAOBase{

    // 1- Declaration des variables
    // 1.1- Pour la création de la table utilisateurs

    public static final String USER_TABLE_NAME = "utilisateurs";
    public static final String USER_ID = "id";
    public static final String USER_LASTNAME = "nom";
    public static final String USER_FIRSTNAME = "prenom";
    public static final String USER_PHONE = "telephone";
    public static final String USER_NAME = "nomutilisateur";
    public static final String USER_PASSWORD = "motdepasse";
    public static final String USER_CATEGORIE = "categorieutilisateur";

//---------------------------------------------------------

    // 2- Constructeur de l'Utilisateur DAO
    public UtilisateurDAO(Context pcontext) {
        super(pcontext);
    }

//----------------------------------------------------------------
//3 - La methode pour Ajouter un utilisateur à la base de données.
    public void ajouter(Utilisateur utilisateur){

        ContentValues value = new ContentValues();
        value.put(USER_LASTNAME,utilisateur.getNom());
        value.put(USER_FIRSTNAME,utilisateur.getPrenom());
        value.put(USER_PHONE,utilisateur.getNumeroTelephone());
        value.put(USER_NAME,utilisateur.getNomUtilisateur());
        value.put(USER_PASSWORD,utilisateur.getMotDePasse());
        value.put(USER_CATEGORIE,utilisateur.getCategorieUtilisateur());

        mDb.insert(USER_TABLE_NAME,null,value);
    }



//----------------------------------------------------------------
//4 - La methode pour selectionner un utilisateur dans la base de données, connaissant son username et son password
public Utilisateur getUtilisateur(String unnomdUtilisateur,String unmotdepasse){
        Utilisateur utilisateur = null;
        Cursor cursor = mDb.rawQuery("SELECT * FROM utilisateurs WHERE nomutilisateur = ? and motdepasse =?",new String[]{unnomdUtilisateur, unmotdepasse});

    while (cursor.moveToNext()) {

        String nom = cursor.getString(1);
        String prenom = cursor.getString(2);
        String numerotelephone = cursor.getString(3);
        String nomutilisateur = cursor.getString(4);
        String motdepasse = cursor.getString(5);
        String categorieutilisateur = cursor.getString(6);

        utilisateur = new Utilisateur(nom,prenom,numerotelephone,nomutilisateur,motdepasse,categorieutilisateur);
    }
    cursor.close();

        return utilisateur;


}


//----------------------------------------------------------------
//5 - La methode pour compter le nombre de d'utilisateurs dans la base pour un username donné

    public int countUnUtilisateur(String unnomdUtilisateur){
        int compte =0;
        Cursor cursor = mDb.rawQuery("SELECT * FROM utilisateurs WHERE nomutilisateur = ?",new String[]{unnomdUtilisateur});
        compte = cursor.getCount();

        cursor.close();

        return compte;


    }




//----------------------------------------------------------------
//6 - La methode pour compter le nombre de d'utlisateurs total dans la base
public int countTousLesUtilisateur(){
    int compte =0;
    Cursor cursor = mDb.rawQuery("SELECT * FROM utilisateurs ",null);
    compte = cursor.getCount();

    cursor.close();

    return compte;


}


//----------------------------------------------------------------
// 4- Selectionner tous les parents
    public ArrayList<Utilisateur> selectionnerTousLesUtilisateurs(String unecategorie){

        Utilisateur utilisateur=null;
        ArrayList<Utilisateur> listedesutilisateurs =new ArrayList<>();

        Cursor cursor = mDb.rawQuery("SELECT * FROM utilisateurs WHERE categorieutilisateur = ?",new String[]{unecategorie});

        while (cursor.moveToNext()) {

            String nom = cursor.getString(1);
            String prenom = cursor.getString(2);
            String numerotelephone = cursor.getString(3);
            String nomutilisateur = cursor.getString(4);
            String motdepasse = cursor.getString(5);
            String categorieutilisateur = cursor.getString(6);


            utilisateur = new Utilisateur(nom,prenom,numerotelephone,nomutilisateur,motdepasse,categorieutilisateur);
            listedesutilisateurs.add(utilisateur);
        }
        cursor.close();

        return listedesutilisateurs;

    }










}
