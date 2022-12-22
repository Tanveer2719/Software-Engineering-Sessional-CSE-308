package Question_2.Models;

public abstract class Car{
    protected String name;
    protected String color;
    protected String country;
    protected String engineType;
    protected String driveTrain;

    public abstract void create();

    protected void setName(String name) {
        this.name = name;
    }

    protected void setColor(String color) {
        this.color = color;
    }

    protected void setCountry(String country) {
        this.country = country;
    }

    protected void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    protected void setDriveTrain(String driveTrain) {
        this.driveTrain = driveTrain;
    }

    public String getColor() {
        return color;
    }

    public String getName(){
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getDriveTrain() {
        return driveTrain;
    }

    public void printCar() {
        System.out.println("The car selected for you is: " + getName());
        System.out.println("It is " +  getColor() + " in colour.");
        System.out.println("It is manufactured in " +  getCountry());
        System.out.println("It has a " +  getEngineType()+" engine.");
        System.out.println("It uses "+ getDriveTrain() + " drive-train.");
    }

}