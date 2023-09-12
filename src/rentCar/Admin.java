package rentCar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Admin extends User {
	
    private List<Employee> employeeList;
    private List<Car> carList;

    public Admin(int id_user, String login, String password) {
    	
        super(id_user, login, password);
        this.employeeList = new ArrayList<>();
        this.carList = new ArrayList<>();
        
    }
    
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
    
///////////////////////CRUD Employees////////////////////////////////////////////////////////
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void editEmployee(int employeeId, LocalDate newHireDate, float newSalary, String newRole) {
        for (Employee employee : employeeList) {
            if (employee.getId_user() == employeeId) {
                employee.setHireDate(newHireDate);
                employee.setSalary(newSalary);
                employee.setRole(newRole);
                break;
            }
        }
    }
    
    public boolean deleteEmployee(int employeeId) {
        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId_user() == employeeId) {
                iterator.remove();
                return true; 
            }
        }
        return false;
    }
    
///////////////////////CRUD Cars////////////////////////////////////////////////////////
    public void addCar(Car car) {
        carList.add(car);
    }

    public void editCar(int carId, String newBrand, String newModel, int newYear) {
        for (Car car : carList) {
            if (car.getId_Car() == carId) {
                car.setBrand(newBrand);
                car.setModel(newModel);
                car.setYear(newYear);
                break;
            }
        }
    }

    public boolean deleteCar(int carId) {
        Iterator<Car> iterator = carList.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            if (car.getId_Car() == carId) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
////////////////////////////////////////////////////////////////////////////////////////////////

}
