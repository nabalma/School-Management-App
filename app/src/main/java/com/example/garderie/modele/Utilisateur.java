package com.example.garderie.modele;

public class Utilisateur {

    // Déclaration de variables
    private String id;
    private String nom;
    private String prenom;
    private String numeroTelephone;
    private String nomUtilisateur;
    private String motDePasse;
    private String categorieUtilisateur;

    // Constructeurs

    // ** Username et password
    public Utilisateur(String nomUtilisateur, String motDePasse) {
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
    }
    // ** Tous les parametres
    public Utilisateur(String nom, String prenom, String numeroTelephone, String nomUtilisateur, String motDePasse, String categorieUtilisateur) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTelephone = numeroTelephone;
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
        this.categorieUtilisateur = categorieUtilisateur;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getCategorieUtilisateur() { return categorieUtilisateur; }

    // Setteurs

    /* public void setId(String nom) {this.id = id;} */ // Le id ne se set pas.

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setCategorieUtilisateur(String categorieUtilisateur) {
        this.categorieUtilisateur = categorieUtilisateur;
    }
}
