package rentCar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
        	
            // S'authentifier
            System.out.println("Choisissez votre rôle :");
            System.out.println();
            System.out.println("1. Admin");
            System.out.println("2. Responsable de Maintenance");
            System.out.println("3. Responsable Commercial");
            System.out.println("4. Quitter");
            System.out.println();
            System.out.print("Votre choix : ");
            int roleChoice = sc.nextInt();

            // Validation du choix
            User user = null;
            switch (roleChoice) {
                case 1:
                    user = new Admin(1, "admin@live.fr", "admin");
                    break;
                case 2:
                    user = new RespoMaintenance(LocalDate.now(), 3000.0f, "Responsable de Maintenance",
                            "maintenance", "maintenance", 2, "maintenance@live.fr", "123");
                    break;
                case 3:
                    user = new RespoCommercial(LocalDate.now(), 2500.0f, "Responsable Commercial",
                            "commercial", "commercial", 3, "commercial@live.fr", "1234");
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Choix invalide.");
                    break;
            }

            //Verification
            if (user != null && !exit) {
                System.out.print("Login : ");
                String login = sc.next();
                System.out.print("Mot de passe : ");
                String password = sc.next();

                if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                    //connected
                    user.seConnecter();
////////////////////////////////////////////////ADMIN/////////////////////////////////////////////
                    //verification
                    if (user instanceof Admin) {
                        System.out.println("Authentifié en tant qu'Admin");

                        boolean logout = false;
                        while (!logout) {
                        	
                            System.out.println("Choisissez une option :");
                            System.out.println("1. Ajouter un véhicule");
                            System.out.println("2. Modifier un véhicule");
                            System.out.println("3. Supprimer un véhicule");
                            System.out.println("4. Ajouter un employé");
                            System.out.println("5. Modifier un employé");
                            System.out.println("6. Supprimer un employé");
                            System.out.println("7. List employee");
                            System.out.println("8. LSe déconnecter");
                            System.out.print("Votre choix : ");
                            int adminChoice = sc.nextInt();
                            Admin admin = new Admin(1, "admin@live.fr", "admin");
                            switch (adminChoice) {
//////////////////////////////////////CRUD Car/////////////////////////////////////////////////////////////////
                                case 1:
                                    System.out.print("ID du véhicule : ");
                                    int carId = sc.nextInt();
                                    System.out.print("Marque du véhicule : ");
                                    String brand = sc.next();
                                    System.out.print("Modèle du véhicule : ");
                                    String model = sc.next();
                                    System.out.print("Année du véhicule : ");
                                    int year = sc.nextInt();
                                    Car newCar = new Car(carId, brand, model, year);
                                    admin.addCar(newCar);
                                    System.out.println("Le véhicule a été ajouté avec succès.");
                                    break;
                                case 2:
                                    System.out.print("ID du véhicule à modifier : ");
                                    int carIdToModify = sc.nextInt();
                                    Car carToModify = Car.findCarById(carIdToModify, admin.getCarList());
                                    if (carToModify != null) {
                                        System.out.print("Nouvelle marque : ");
                                        String newBrand = sc.next();
                                        System.out.print("Nouveau modèle : ");
                                        String newModel = sc.next();
                                        System.out.print("Nouvelle année : ");
                                        int newYear = sc.nextInt();

                                        admin.editCar(carIdToModify, newBrand, newModel, newYear);
                                        System.out.println("Le véhicule a été modifié avec succès.");
                                    } else {
                                        System.out.println("Aucun véhicule trouvé avec l'ID spécifié.");
                                    }
                                    break;
                                case 3:
                                    // Supprimer un véhicule
                                    System.out.print("ID du véhicule à supprimer : ");
                                    int carIdToDelete = sc.nextInt();
                                    boolean carDeleted = admin.deleteCar(carIdToDelete);
                                    if (carDeleted) {
                                        System.out.println("Le véhicule a été supprimé avec succès.");
                                    } else {
                                        System.out.println("Aucun véhicule trouvé avec l'ID spécifié.");
                                    }
                                    break;
///////////////////////////////////////CRUD employees////////////////////////////////////////////////////////////
                                case 4:
                                	System.out.print("Date d'embauche (AAAA-MM-JJ) : ");
                                    String hireDateStr = sc.next();
                                    LocalDate hireDate = LocalDate.parse(hireDateStr);
                                    System.out.print("Salaire : ");
                                    float salary = sc.nextFloat();
                                    System.out.print("Rôle : ");
                                    String role = sc.next();
                                    System.out.print("ID de l'employé : ");
                                    int employeeId = sc.nextInt();
                                    System.out.print("Login : ");
                                    String login1 = sc.next();
                                    System.out.print("Mot de passe : ");
                                    String password1 = sc.next();

                                    Employee newEmployee = new Employee(hireDate, salary, null, role, employeeId, login1, password1);
                                    admin.addEmployee(newEmployee);
                                    System.out.println("L'employé a été ajouté avec succès.");
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    break;
                                
                                	
                                case 7:
                                    Admin admin1 = (Admin) user;
                                    List<Employee> employeeList = admin1.getEmployeeList();
                                    System.out.println("Liste des employés :");
                                    for (Employee employee : employeeList) {
                                        System.out.println("ID : " + employee.getId_user());
                                        System.out.println("Nom : " + employee.getName());
                                        System.out.println("Email : " + employee.getEmail());
                                        // Afficher d'autres informations pertinentes de l'employé
                                        System.out.println("---------------------------");
                                    }
                                    break;
                                case 8:
                                    logout = true;
                                    break;
                                default:
                                    System.out.println("Choix invalide.");
                                    break;
                            }
                        }
                        
                    } 
//////////////////////////////////////////Maintenance//////////////////////////////////////////////////
                    else if (user instanceof RespoMaintenance) {
                        System.out.println("Authentifié en tant que Responsable de Maintenance");

                        boolean logout = false;
                        while (!logout) {
                        	
                            System.out.println("Choisissez une option :");
                            System.out.println("1. Gérer l'entretien d'une voiture");
                            System.out.println("2. Se déconnecter");
                            System.out.print("Votre choix : ");
                            int maintenanceChoice = sc.nextInt();

                            switch (maintenanceChoice) {
                                case 1:
                                    RespoMaintenance respoMaintenance = (RespoMaintenance) user;
                                    respoMaintenance.addEntretien();
                                    break;
                                case 2:
                                    logout = true;
                                    break;
                                default:
                                    System.out.println("Choix invalide.");
                                    break;
                            }
                        }
                    } 
///////////////////////////////////////////Commercial/////////////////////////////////////////////////////                   
                    else if (user instanceof RespoCommercial) {
                        System.out.println("Authentifié en tant que Responsable Commercial");

                        
                        boolean logout = false;
                        while (!logout) {
                            System.out.println("Choisissez une option : ");
                            System.out.println("1. Ajouter contrat ");
                            System.out.println("2. Afficher le catalogue des offres ");
                            System.out.println("3. Ajouter une offre");
                            System.out.println("4. Supprimer une offre");
                            System.out.println("5. Se déconnecter");
                            System.out.print("Votre choix : ");
                            
                            
                            int commercialChoice = sc.nextInt();

                            switch (commercialChoice) {
                                case 1:
                                    ((RespoCommercial) user).addContrats();
                                    break;
                                case 2:
                                    ((RespoCommercial) user).provideCatalog();
                                    break;
                                case 3:
                                    ((RespoCommercial) user).addOffer();
                                    break;
                                case 4:
                                    ((RespoCommercial) user).removeOffer();
                                    break;
                                case 5:
                                    logout = true;
                                    break;
                                default:
                                    System.out.println("Choix invalide.");
                                    break;
                            }
                        }
                    }

                    user.seDeconnecter();
                } else {
                    System.out.println("Identifiants de connexion incorrects.");
                }
            }
        }

        sc.close();
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*creation voitures*/
        Car car1 = new Car(1, "Volkswagen", "Tiguan", 2021);
        Car car2 = new Car(2, "Renault", "Clio 5", 2019);
        Car car3 = new Car(3, "Citroën", "C4", 2022);


        /*Liste voitures*/
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        /*diponibilite des voitures*/
        car1.setAvailable(true);
        car2.setAvailable(false);
        car3.setAvailable(true);
    }
}
