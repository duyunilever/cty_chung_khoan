package handle;

import entity.Employee;
import entity.Manager;
import entity.Marketing;
import entity.NormalEmp;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeHandle {
    public Employee inputInfo(Scanner scanner, int i){
        System.out.println("Nhập tên NV thứ " + (i+1));
        String name = scanner.nextLine();
        System.out.println("Nhập lương");
        double salary = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập chức vụ\n" +
                "1: NV hành chính\n" +
                "2: NV Marketing\n" +
                "3: Manager");
        int n = Integer.parseInt(scanner.nextLine());
        switch (n) {
            case 1:
                return new NormalEmp(name, salary);
            case 2:
                System.out.println("Nhập doanh thu");
                double revenue = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập mức hoa hồng");
                double bonus = Double.parseDouble(scanner.nextLine());
                return new Marketing(name, salary, revenue, bonus);
            case 3:
                System.out.println("Nhập lương trách nhiệm");
                double salaryResp = Double.parseDouble(scanner.nextLine());
                return new Manager(name, salary, salaryResp);
        }
        return null;
    }
    public Employee findById (Scanner scanner, ArrayList<Employee> employees){
        int id = Integer.parseInt(scanner.nextLine());
        for (Employee employee: employees
             ) {
            if (id == employee.getId()){
                return employee;
            }
        }
        return null;
    }
    public void removeEmp (Scanner scanner, ArrayList<Employee> employees){
        employees.remove(findById(scanner, employees));
    }
    public void updateInfo (Scanner scanner, ArrayList<Employee> employees){
        Employee employee = findById(scanner, employees);
        System.out.println("Thông tin cần thay đổi\n" +
                "1: Tên\n" +
                "2: Lương\n");
        int n = Integer.parseInt(scanner.nextLine());
        switch (n){
            case 1:
                System.out.println("Nhập tên mới");
                String nameNew = scanner.nextLine();
                employee.setName(nameNew);
                break;
            case 2:
                System.out.println("Nhập lương mới");
                double salaryNew = Double.parseDouble(scanner.nextLine());
                employee.setSalary(salaryNew);
                break;
        }
    }
    public void findBySalary (Scanner scanner, ArrayList<Employee>employees){
        System.out.println("Nhập số lương cần tìm nhân viên theo");
        double salaryFind = Double.parseDouble(scanner.nextLine());
        System.out.println("Cần tìm các nhân viên có lương\n" +
                "1: Lớn hơn hoặc Bằng\n" +
                "2: Nhỏ hơn hoặc Bằng");
        int n = Integer.parseInt(scanner.nextLine());
        for (Employee employee: employees
             ) {
            switch (n){
                case 1: if (salaryFind >= employee.getSalary()) System.out.println(employees);
                    break;
                case 2: if (salaryFind <= employee.getSalary()) System.out.println(employees);
                    break;
            }
        }
    }
    public void printInfoIncomeVAT (ArrayList<Employee>employees){
        System.out.println("Thông tin thu nhập và thuế");
        for (Employee employee: employees
             ) {
            System.out.println(employee.getName() + "Thu nhập bằng " + employee.calcIncome() + "\n" +
                    "Thuế bằng " + employee.calcVAT());
        }
    }
    public ArrayList<Employee> softByIncome (ArrayList<Employee>employees){
        int count = 0;
        for (Employee employee: employees
             ) {
            count++;
        }
            Employee temp;
            for (int i = 0; i < count - 1; i++) {
                for (int j = i+1; j < count; j++) {
                    if (employees.get(i).calcIncome() < employees.get(j).calcIncome()){
                        temp = employees.get(j);
                        employees.set(j, employees.get(i));
                        employees.set(i, temp);
                    }
                }
            }
        System.out.println(employees);
        return employees;
    }
    public void topIncome (ArrayList<Employee>employees){
        ArrayList<Employee>employees1 = softByIncome(employees);
        System.out.println("5 nguời có mức thu nhập cao nhất là\n" +
                "1: " + employees1.get(0) + "\n" +
                "2: " + employees1.get(1) + "\n" +
                "3: " + employees1.get(2) + "\n" +
                "4: " + employees1.get(3) + "\n" +
                "5: " + employees1.get(4) + "\n");
    }
}
