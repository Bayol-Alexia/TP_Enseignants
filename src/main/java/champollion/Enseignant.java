package champollion;

import java.util.ArrayList;
import java.util.List;

public class Enseignant extends Personne {

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    List<ServicePrevu> servicesPrevus = new ArrayList<ServicePrevu>();
    List<Intervention> interventions = new ArrayList<Intervention>();

    public int heuresPrevues() {
        float total=0;
        for (ServicePrevu services : servicesPrevus){
            total+=services.getCM()*1.5;
            total+=services.getTD();
            total+=services.getTP()*0.75;
        }
        return Math.round(total);
    }

    public boolean enSousService(){
        if (this.heuresPrevues()<192){
            return true;
        } else {
            return false;
        }
    }
    

    public int heuresPrevuesPourUE(UE ue) {
        float total=0;
        for (ServicePrevu services : servicesPrevus){
            if (services.getUE().equals(ue)){
                total+=services.getCM()*1.5;
                total+=services.getTD();
                total+=services.getTP()*0.75;
            }
        }
        return Math.round(total);
    }

   
    public void ajouteEnseignement(UE ue, int CM, int TD, int TP) {
        boolean existant= false;
        for (ServicePrevu services : servicesPrevus){
            //si l'enseignant possède déjà un service prévu pour l'UE en paramètre, on additionne les heures
            if (services.getUE().equals(ue)){
                services.setCM(services.getCM()+CM);
                services.setTD(services.getTD()+TD);
                services.setTP(services.getTP()+TP);
                existant=true;
            }
        }
        if (existant==false){
            servicesPrevus.add(new ServicePrevu(this,ue, CM, TD, TP)); //si l'enseignant n'a pas de service prévu, on l'ajoute à la liste
        }
    }
    
    public void ajouteIntervention(Intervention inter) {
        for (ServicePrevu services : servicesPrevus){
            //si on veut ajouter une intervention à une UE et qu'un enseignant n'a pas d'enseignements planifiés dans cet UE, on lève une exception
            if (!(services.getUE().equals(inter.getMatiere()))){
                throw new IllegalArgumentException("L'UE n'est pas planifiée pour cet enseignant");
            }
            interventions.add(inter);
        }
    }
    
    
    public int resteAPlanifier(UE ue, TypeIntervention type) {

        int heuresPrevues=0;
        for (ServicePrevu services : servicesPrevus){
            //si on veut rechercher le nombre d'heures à planifier dans une UE et qu'un enseignant n'a pas d'enseignements planifiés dans cet UE, on lève une exception
            if (!(services.getUE().equals(ue))){
                throw new IllegalArgumentException("Cette UE n'est pas planifié");
            }

            else {
                switch (type) {
                    case CM:
                        heuresPrevues=services.getCM();
                        break;
                    case TD:
                        heuresPrevues=services.getTD();
                        break;
                    case TP:
                        heuresPrevues=services.getTP();
                        break;
                    default:
                        break;
                }
            }
        }
        int heuresEffect=0;
        for (Intervention inter : interventions){
            if (inter.getMatiere().equals(ue) && inter.getType().equals(type)){
                heuresEffect=inter.getDuree();
            }
        }
        return (heuresPrevues-heuresEffect);
    }


}
