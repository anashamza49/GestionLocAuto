package rentCar;

import java.time.LocalDate;

public class Employee extends User {

    protected LocalDate hireDate;
    private float salary;
    private String role;

    public Employee(LocalDate hireDate, float salary, String job, String role, int id_user, String login, String password) {
        
    	super(id_user, login, password);
        this.hireDate = hireDate;
        this.salary = salary;
        this.role = role;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}


}
