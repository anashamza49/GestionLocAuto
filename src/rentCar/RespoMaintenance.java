package rentCar;

import java.time.LocalDate;
import java.util.Scanner;

public class RespoMaintenance extends Employee {

    private Scanner scanner;

    public RespoMaintenance(LocalDate hireDate, float salary, String role, String name, String email, int id_user, String login, String password) {
        
    	super(hireDate, salary, role, name, id_user, login, password);
        this.scanner = new Scanner(System.in);
    }

    public void addEntretien() {
    	
        System.out.println("Gestion de l'entretien - Responsable de Maintenance");
        System.out.println("===================================================");
        System.out.println("Veuillez saisir les informations de l'entretien :");

        System.out.print("ID de la voiture : ");
        int carId = Integer.parseInt(scanner.nextLine());

        System.out.print("Kilométrage : ");
        int mileage = Integer.parseInt(scanner.nextLine());

        System.out.print("Type d'entretien : ");
        String maintenanceType = scanner.nextLine();

        System.out.print("Description : ");
        String description = scanner.nextLine();
        
        Car car = findCarById(carId);
        if (car != null) {

            car.setKilometrage(mileage);
            car.setDernierEntretien(maintenanceType,description);

            System.out.println("Entretien enregistré avec succès pour la voiture : " + car.getBrand()+" "+car.getModel());
        } else {
            System.out.println("Voiture non trouvée avec l'ID : "+carId);
        }
    }
    
    private Car findCarById(int carId) {
        return null;
    }
}
