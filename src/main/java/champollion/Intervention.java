/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package champollion;

import java.util.Date;

/**
 *
 * @author Alexia
 */
public class Intervention {
    private Date debut;
    private int duree;
    private boolean annulee;
    private int heureDebut;
    private TypeIntervention type;
    private UE matiere;

    public Intervention(Date debut, int duree, boolean annulee, int heureDebut, TypeIntervention type, UE matiere) {
        this.debut = debut;
        this.duree = duree;
        this.annulee = annulee;
        this.heureDebut = heureDebut;
        this.type = type;
        this.matiere = matiere;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }

    public int getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(int heureDebut) {
        this.heureDebut = heureDebut;
    }

    public TypeIntervention getType() {
        return type;
    }

    public void setType(TypeIntervention type) {
        this.type = type;
    }

    public UE getMatiere() {
        return matiere;
    }

    public void setMatiere(UE matiere) {
        this.matiere = matiere;
    }
  
    
}
