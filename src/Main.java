import entity.Employee;
import handle.EmployeeHandle;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng NV");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Employee> employees = new ArrayList<>();
        EmployeeHandle employeeHandle = new EmployeeHandle();
        for (int i = 0; i < n; i++) {
            Employee employee = employeeHandle.inputInfo(scanner,i);
            employees.add(employee);
        }
        System.out.println(employees);
        System.out.println("Nhập id NV cần xóa");
        employeeHandle.removeEmp(scanner, employees);
        System.out.println("Nhập id NV cần update");
        employeeHandle.updateInfo(scanner, employees);
        employeeHandle.findBySalary(scanner, employees);
        employeeHandle.printInfoIncomeVAT(employees);
        employeeHandle.softByIncome(employees);
        employeeHandle.topIncome(employees);
    }
}