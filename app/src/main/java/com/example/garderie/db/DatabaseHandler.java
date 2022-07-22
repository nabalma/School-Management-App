package com.example.garderie.db;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHandler extends SQLiteOpenHelper{


    // 1- Declaration des variables pour la création des tables
    // 1.1- Pour la création de la table utilisateurs

    public static final String USER_TABLE_NAME = "utilisateurs";
    public static final String USER_ID = "id";
    public static final String USER_LASTNAME = "nom";
    public static final String USER_FIRSTNAME = "prenom";
    public static final String USER_PHONE = "telephone";
    public static final String USER_NAME = "nomutilisateur";
    public static final String USER_PASSWORD = "motdepasse";
    public static final String USER_CATEGORIE = "categorieutilisateur";

    // 1.2- Pour la création de la table Evenement

    public static final String EVENT_TABLE_NAME = "evenements";
    public static final String EVENT_ID = "idevenement";
    public static final String EVENT_CATEGORIE = "categorieevenement";
    public static final String EVENT_TITLE = "titreevenement";
    public static final String EVENT_DESCRIPTION = "descriptionevenement";
    public static final String EVENT_AUTHOR = "parentauteurevenement";

    // 1.3- Pour la création de la table Note
    public static final String NOTE_TABLE_NAME = "notes";
    public static final String NOTE_ID = "idnote";
    public static final String GROUPE_ELEVE = "groupeeleve";
    public static final String NOM_PRENOM_ELEVE = "nomprenomeleve";
    public static final String NOTE_ELEVE = "noteeleve";
    public static final String CATEGORIE_NOTE = "categorienote";


    // 1.4- Pour la création de la table XYZ




//------------------------------------------------------------------

    // 2- Constructeurs
    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


//--------------------------------------------------------------------
    // 3- Declaration de la réquète de construction des tables

    //3.1 - requete de construction pour la table Utilisateur
    public static final String USER_TABLE_CREATE =

            "CREATE TABLE " + USER_TABLE_NAME + " (" +
            USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            USER_LASTNAME + " TEXT, "+
            USER_FIRSTNAME + " TEXT, "+
            USER_PHONE + " TEXT, "+
            USER_NAME + " TEXT, "+
            USER_PASSWORD + " TEXT, "+
            USER_CATEGORIE + " TEXT);";

    //3.2 - requete de construction pour la table Evenement
    public static final String EVENT_TABLE_CREATE =

            "CREATE TABLE " + EVENT_TABLE_NAME + " (" +
                    EVENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    EVENT_CATEGORIE + " TEXT, "+
                    EVENT_TITLE + " TEXT, "+
                    EVENT_DESCRIPTION + " TEXT, "+
                    EVENT_AUTHOR + " TEXT);";

    //3.3 - requete de construction pour la table note

    public static final String NOTE_TABLE_CREATE =

            "CREATE TABLE " + NOTE_TABLE_NAME + " (" +
                    NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    GROUPE_ELEVE + " TEXT, "+
                    NOM_PRENOM_ELEVE + " TEXT, "+
                    NOTE_ELEVE + " INTEGER, "+
                    CATEGORIE_NOTE + " TEXT);";

    //3.4 - requete de construction pour la table note

//---------------------------------------------------------------------------
    //4 - Declaration de la réquète de supression des tables
    // 4.1- Supression de la table utilisateurs
    public static final String USER_TABLE_DROP = "DROP TABLE IF EXISTS " + USER_TABLE_NAME + ";";

    // 4.2- Supression de la table Evenement
    public static final String EVENT_TABLE_DROP = "DROP TABLE IF EXISTS " + EVENT_TABLE_NAME + ";";

    // 4.2- Supression de la table Note
    public static final String NOTE_TABLE_DROP = "DROP TABLE IF EXISTS " + NOTE_TABLE_NAME + ";";




//-----------------------------------------------------------------------------------------
    //5- Declaration des methodes
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creation of Table Utilisateurs
        db.execSQL(USER_TABLE_CREATE);

        // Creation of Table Utilisateurs
        db.execSQL(EVENT_TABLE_CREATE);

        // Creation of Table Notes
        db.execSQL(NOTE_TABLE_CREATE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Upgrade of Table Utilisateurs
        db.execSQL(USER_TABLE_DROP);


        // Upgrade of Table Evenement
        db.execSQL(EVENT_TABLE_DROP);

        // Upgrade of Table nOTES
        db.execSQL(NOTE_TABLE_DROP);


        // Recreation de la base de données
        onCreate(db);

    }
}
