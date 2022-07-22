package com.example.garderie.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.garderie.db.DatabaseHandler;


public abstract class DAOBase {

// 1- Détermination de la version : Nous sommes à la première version de la base
    protected final static int VERSION = 7;

// 2- Détermination du nom du fichier qui représente ma base sera appelé database.db
    protected final static String NOM = "database.db";

// 3- Détermination de la base de données : On cree la base de données que nous allons appelé mDb
    protected SQLiteDatabase mDb = null;

// 4- Détermination du handler : nous allons creer un handler que nous allons appelé mHandler
    protected DatabaseHandler mHandler = null;

// 5- Constructeur du DAOBase (Faire generate, mais prendre Select None)
    // 5.1 -- Constructeur

    public DAOBase(Context pcontext) {
        this.mHandler = new DatabaseHandler(pcontext,NOM,null,VERSION);
        open(); // N'oublions pas le open ci dessous, de meme que sa methode a creer plus bas
    }

    // 5.2 -- La methode Open du constructeur

// La methode Open contenu dans le constructeur du DAO ci dessus :
    public SQLiteDatabase open(){
        mDb = mHandler.getWritableDatabase();
        return mDb;
    }

// Les autres  methodes du DAOBase :

    public void close() {
        mDb.close();
    }

    public SQLiteDatabase getDb() {
        return mDb;
    }




}
