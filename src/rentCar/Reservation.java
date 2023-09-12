package rentCar;

import java.time.LocalDate;

public class Reservation {
	
    private String nomClient;
    private String telephoneClient;
    private LocalDate dateReservation;
    private int dureeLocation;
    private String typeVoiture;
    private int age;
    private String numeroPermis;

    public Reservation(String nomClient, String telephoneClient, LocalDate dateReservation, int dureeLocation,String typeVoiture, int age, String numeroPermis) {
        
    	this.nomClient = nomClient;
        this.telephoneClient = telephoneClient;
        this.dateReservation = dateReservation;
        this.dureeLocation = dureeLocation;
        this.typeVoiture = typeVoiture;
        this.age = age;
        this.numeroPermis = numeroPermis;
    }

/////////////////////showin client info////////////////////////////////////////////////////////////
    
    public void afficherDetails() {
        System.out.println("Détails du contrat :");
        System.out.println("Nom du client :" + nomClient);
        System.out.println("Numéro de téléphone :" + telephoneClient);
        System.out.println("Date de réservation :" + dateReservation);
        System.out.println("Durée de location :" + dureeLocation);
        System.out.println("Type de voiture :" + typeVoiture);
        System.out.println("Âge :" + age);
        System.out.println("Numéro de permis de conduire :" + numeroPermis);
    }

}
