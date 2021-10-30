package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    public List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService() {

    }

    public EmployeePayrollService(ArrayList<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;

    }

    public static void main(String[] args) {
        System.out.println("<-----Welcome to Employee Payroll Service Problem----->");
        System.out.println();
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData();
    }

    public void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Enter employee ID -> ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee name -> ");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee salary -> ");
        double salary = consoleInputReader.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(id, name, salary));

    }

    public void writeEmployeePayrollData() {
        System.out.println("\n Writing Employee Payroll Roaster to console\n" + employeePayrollList);
    }
}
