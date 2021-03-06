package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

    public enum IOService {CONSOLE_IO, FILE_IO, REST_IO, DB_IO}

    public List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService() {

    }

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;

    }

    public static void main(String[] args) {
        System.out.println("<-----Welcome to Employee Payroll Service Problem----->");
        System.out.println();
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);
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

    public void writeEmployeePayrollData(IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO)) {
            System.out.println("\n Writing Employee Payroll Roaster to console\n" + employeePayrollList);
        } else if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOService().writeData(employeePayrollList);
    }

    public void printData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOService().printData();
    }

    public long countEntries(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            return new EmployeePayrollFileIOService().countEntries();
        return 0;
    }
}
