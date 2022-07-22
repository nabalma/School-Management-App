package com.example.garderie.modele;

public class Evenement {

    // Déclaration de variables
    private String idEvenement;
    private String categorieEvenement;
    private String titreEvenement;
    private String descriptionEvenement;
    private String parentAuteurEvenement;

    // Constructeurs

    // Constructeur avec tous les parametres
    public Evenement(String categorieEvenement, String titreEvenement, String descriptionEvenement, String parentAuteurEvenement) {
        this.idEvenement = idEvenement;
        this.categorieEvenement = categorieEvenement;
        this.titreEvenement = titreEvenement;
        this.descriptionEvenement = descriptionEvenement;
        this.parentAuteurEvenement = parentAuteurEvenement;
    }


    // Getters
    public String getIdEvenement() {
        return idEvenement;
    }

    public String getCategorieEvenement() {
        return categorieEvenement;
    }

    public String getTitreEvenement() {
        return titreEvenement;
    }

    public String getDescriptionEvenement() {
        return descriptionEvenement;
    }

    public String getParentAuteurEvenement() {
        return parentAuteurEvenement;
    }

    // Setters


    public void setIdEvenement(String idEvenement) {
        this.idEvenement = idEvenement;
    }

    public void setCategorieEvenement(String categorieEvenement) {
        this.categorieEvenement = categorieEvenement;
    }

    public void setTitreEvenement(String titreEvenement) {
        this.titreEvenement = titreEvenement;
    }

    public void setDescriptionEvenement(String descriptionEvenement) {
        this.descriptionEvenement = descriptionEvenement;
    }

    public void setParentAuteurEvenement(String parentAuteurEvenement) {
        this.parentAuteurEvenement = parentAuteurEvenement;
    }
}
