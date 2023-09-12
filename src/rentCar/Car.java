package rentCar;

import java.util.List;

public class Car {

    private int id_Car;
    private String brand;
    private String model;
    private int year;
    private boolean available;
    private int kilometrage;
    private String dernierEntretienType;
    private String dernierEntretienDescription;

    public Car(int id_Car, String brand, String model, int year) {

        this.id_Car = id_Car;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.available = true;
        this.kilometrage = 0;
        this.dernierEntretienType = "";
        this.dernierEntretienDescription = "";
    }

    public int getId_Car() {
        return id_Car;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getDernierEntretienType() {
        return dernierEntretienType;
    }

    public String getDernierEntretienDescription() {
        return dernierEntretienDescription;
    }

    public void setDernierEntretien(String type, String description) {
        this.dernierEntretienType = type;
        this.dernierEntretienDescription = description;
    }
//////////////////////Searching for car usin ID//////////////////////////
    public static Car findCarById(int carId, List<Car> carList) {
        for (Car car : carList) {
            if (car.getId_Car() == carId) {
                return car;
            }
        }
        return null;
    }
////////////////////////Show availabale cars/////////////////////////////////////////////////////////////
    public static void listCars(List<Car> carList) {
        System.out.println("Les voitures disponibles :");
        for (Car car : carList) {
            if (car.isAvailable()) {
                System.out.println(car.getBrand() + " " + car.getModel() + " (" + car.getYear() + ")");
            }
        }
    }

}
