package rentCar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RespoCommercial extends Employee {
	
        private Scanner scanner;
        private List<String> catalog;

        public RespoCommercial(LocalDate hireDate, float salary, String role, String name, String email, int id_user, String login, String password) {
            super(hireDate, salary, role, name, id_user, login, password);
            this.scanner = new Scanner(System.in);
            this.catalog = new ArrayList<>();
        }
//////////////////////////Add new contrat//////////////////////////////////////////////
    public void addContrats() {
    	
        System.out.println("Gestion des contrats - Responsable Commercial");
        System.out.println("===========================================");
        System.out.println("Veuillez saisir les informations du contrat :");

        System.out.print("Nom complet du client : ");
        String nomClient = scanner.nextLine();

        System.out.print("Numéro de téléphone : ");
        String telephoneClient = scanner.nextLine();

        System.out.print("Date de réservation (AAAA-MM-JJ) : ");
        LocalDate dateReservation = LocalDate.parse(scanner.nextLine());

        System.out.print("Durée de location : ");
        int dureeLocation = Integer.parseInt(scanner.nextLine());

        System.out.print("Type de voiture : ");
        String typeVoiture = scanner.nextLine();

        System.out.print("Âge minimum requis : ");
        int ageMinimum = Integer.parseInt(scanner.nextLine());

        System.out.print("Numéro de permis de conduire : ");
        String numeroPermis = scanner.nextLine();

        Reservation reservation = new Reservation(nomClient, telephoneClient, dateReservation, dureeLocation, typeVoiture, ageMinimum, numeroPermis);
        reservation.afficherDetails();

        System.out.println("Contrat enregistré avec succès !");
        
    }
////////////////////////////Show catalogue///////////////////////////////////
    public void provideCatalog() {
        System.out.println("Catalogue des offres de l'agence :");
        for (int i = 0; i < catalog.size(); i++) {
            System.out.println((i + 1) + ". " + catalog.get(i));
        }
    }
//////////////////////////CRUD Offers///////////////////////////////////////
    public void addOffer() {
        System.out.println("Ajouter une offre au catalogue :");
        System.out.print("Nom de l'offre: ");
        String offer = scanner.nextLine();
        catalog.add(offer);
        System.out.println("Offre ajoutée avec succès !!!");
    }

    public void removeOffer() {
        System.out.println("Supprimer une offre:");
        System.out.print("Numéro de l'offre à supprimer: ");
        int offerIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (offerIndex >= 0 && offerIndex < catalog.size()) {
            String removedOffer = catalog.remove(offerIndex);
            System.out.println("L'offre \"" + removedOffer + "\" a été supprimée avec succès !");
        } else {
            System.out.println("Numéro d'offre invalide!!!");
        }
    }
///////////////////////////////////////////////////////////////////////////////////

}
