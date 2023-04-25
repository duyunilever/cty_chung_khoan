package entity;

public abstract class Employee {
    protected static int autoId;
    protected int id;
    protected String name;
    protected double salary;

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(String name, double salary) {
        this.id = ++autoId;
        this.name = name;
        this.salary = salary;
    }

    public abstract double calcIncome();
    public double calcVAT(){
        return calcIncome()<11000?0: 0.1 * (calcIncome()-11000);
    }

}
