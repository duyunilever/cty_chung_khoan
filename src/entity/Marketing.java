package entity;

public class Marketing extends Employee{
    private double revenue;
    private double bonus;

    public Marketing(String name, double salary, double revenue, double bonus) {
        super(name, salary);
        this.revenue = revenue;
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Marketing{" +
                "revenue=" + revenue +
                ", bonus=" + bonus +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public double calcIncome() {
        return salary + revenue * bonus;
    }

}
