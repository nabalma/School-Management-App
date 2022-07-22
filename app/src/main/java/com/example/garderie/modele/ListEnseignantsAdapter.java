package com.example.garderie.modele;

import android.content.Context;
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

public class ListEnseignantsAdapter extends ArrayAdapter<Utilisateur> {

    private Context mContext;
    int mResource;

    public ListEnseignantsAdapter(@NonNull Context context, int resource, @NonNull List<Utilisateur> objects) {
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
        ArrayList<Utilisateur> listeEnseignants = utilisateurDAO.selectionnerTousLesUtilisateurs("Enseignant");


        String id =listeEnseignants.get(position).getId();//getItem(position).getId();
        String nom = listeEnseignants.get(position).getNom();//getItem(position).getNom();
        String prenom = listeEnseignants.get(position).getPrenom();//getItem(position).getPrenom();
        String numeroTelephone =listeEnseignants.get(position).getNumeroTelephone();// getItem(position).getNumeroTelephone();
        String nomUtilisateur =listeEnseignants.get(position).getNomUtilisateur();// getItem(position).getNomUtilisateur();
        String motDePasse = listeEnseignants.get(position).getMotDePasse();//getItem(position).getMotDePasse();
        String categorieUtilisateur = listeEnseignants.get(position).getCategorieUtilisateur();//getItem(position).getCategorieUtilisateur();

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
