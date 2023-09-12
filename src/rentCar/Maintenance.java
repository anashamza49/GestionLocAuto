package rentCar;

import java.time.LocalDate;

public class Maintenance {
	
    protected int id_Maintenance;
    private String description;
    private LocalDate dateMaintenance;
    private float costMaintenance;

    public Maintenance (int id_Maintenance, String description, LocalDate dateMaintenance, float costMaintenance) {
        
    	this.id_Maintenance = id_Maintenance;
        this.description = description;
        this.dateMaintenance = dateMaintenance;
        this.costMaintenance = costMaintenance;
    }

    public int getId_Maintenance(){
        return id_Maintenance;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public LocalDate getDateMaintenance(){
        return dateMaintenance;
    }

    public void setDateMaintenance(LocalDate dateMaintenance) {
        this.dateMaintenance = dateMaintenance;
    }

    public float getCostMaintenance() {
        return costMaintenance;
    }

    public void setCostMaintenance(float costMaintenance) {
        this.costMaintenance = costMaintenance;
    }
}

