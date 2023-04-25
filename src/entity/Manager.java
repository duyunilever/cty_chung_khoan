package entity;

public class Manager extends Employee{
    private double salaryResp;

    public Manager(String name, double salary, double salaryResp) {
        super(name, salary);
        this.salaryResp = salaryResp;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "salaryResp=" + salaryResp +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public double calcIncome() {
        return salary + salaryResp;
    }

}
