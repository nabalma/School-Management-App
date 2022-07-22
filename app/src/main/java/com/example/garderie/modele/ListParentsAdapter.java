package com.example.garderie.modele;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.garderie.R;
import com.example.garderie.dao.UtilisateurDAO;

import java.util.ArrayList;
import java.util.List;

public class ListParentsAdapter extends ArrayAdapter<Utilisateur> {
    private Context mContext;
    int mResource;

    public ListParentsAdapter(@NonNull Context context, int resource, @NonNull List<Utilisateur> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {



        // Affichage de la liste des parents

        // **** Execution de la requete ***
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(getContext());
        ArrayList<Utilisateur> listeParents = utilisateurDAO.selectionnerTousLesUtilisateurs("Parent");


        String id =listeParents.get(position).getId();//getItem(position).getId();
        String nom = listeParents.get(position).getNom();//getItem(position).getNom();
        String prenom = listeParents.get(position).getPrenom();//getItem(position).getPrenom();
        String numeroTelephone =listeParents.get(position).getNumeroTelephone();// getItem(position).getNumeroTelephone();
        String nomUtilisateur =listeParents.get(position).getNomUtilisateur();// getItem(position).getNomUtilisateur();
        String motDePasse = listeParents.get(position).getMotDePasse();//getItem(position).getMotDePasse();
        String categorieUtilisateur = listeParents.get(position).getCategorieUtilisateur();//getItem(position).getCategorieUtilisateur();

        Utilisateur utilisateur = new Utilisateur(nom,prenom,numeroTelephone,nomUtilisateur,motDePasse,categorieUtilisateur);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView nomTextView = (TextView) convertView.findViewById(R.id.idNom);
        TextView prenomTextView = (TextView) convertView.findViewById(R.id.idPrenom);
        TextView telephoneTextView = (TextView) convertView.findViewById(R.id.idTelephone);

        nomTextView.setText(nom);
        prenomTextView.setText(prenom);
        telephoneTextView.setText(numeroTelephone);

        return convertView;



    }
}
