package com.example.garderie.modele;

public class Note {

    // Déclaration de variables

    private String idNote;
    private String groupeEleve;
    private String nomPrenomEleve;
    private int noteEleve;
    private String categorieNote;

    // Constructeurs

    public Note(String groupeEleve, String nomPrenomEleve, int noteEleve, String categorieNote) {
        this.groupeEleve = groupeEleve;
        this.nomPrenomEleve = nomPrenomEleve;
        this.noteEleve = noteEleve;
        this.categorieNote = categorieNote;
    }

    // Getters

    public String getIdNote() {
        return idNote;
    }

    public String getGroupeEleve() {
        return groupeEleve;
    }

    public String getNomPrenomEleve() {
        return nomPrenomEleve;
    }

    public int getNoteEleve() {
        return noteEleve;
    }

    public String getCategorieNote() {
        return categorieNote;
    }

    // Setters

    public void setIdNote(String idNote) {
        this.idNote = idNote;
    }

    public void setGroupeEleve(String groupeEleve) {
        this.groupeEleve = groupeEleve;
    }

    public void setNomPrenomEleve(String nomPrenomEleve) {
        this.nomPrenomEleve = nomPrenomEleve;
    }

    public void setNoteEleve(int noteEleve) {
        this.noteEleve = noteEleve;
    }

    public void setCategorieNote(String categorieNote) {
        this.categorieNote = categorieNote;
    }
}
