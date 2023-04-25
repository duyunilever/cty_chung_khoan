package entity;

public class NormalEmp extends Employee{
    public NormalEmp(String name, double salary) {
        super(name, salary);
    }

    @Override
    public String toString() {
        return "NormalEmp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public double calcIncome() {
        return salary;
    }
}
