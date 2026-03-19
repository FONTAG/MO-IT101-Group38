public class Main {
    public static void main(String[] args) {
        // 1. Create a "Test Employee" using the template we made
        // Employee(ID, Last, First, Bday, Basic, Rice, Phone, Clothes, Hourly)
        Employee testEmp = new Employee("10001", "Crisostomo", "Jose", "01/01/1990", 
                                        62670.00, 1500.00, 1000.00, 1000.00, 373.04);

        // 2. Let's pretend they worked 40 hours this week
        double hoursWorked = 40.0;
        double grossPay = testEmp.calculateGrossSalary(hoursWorked);

        // 3. Print the results to the "Console" to see if the math is right
        System.out.println("------ MotorPH Payroll Test ------");
        System.out.println("Employee Name: " + testEmp.getFullName());
        System.out.println("Gross Salary for " + hoursWorked + " hours: PHP " + grossPay);
        System.out.println("Total Monthly Allowances: PHP " + testEmp.getTotalAllowances());
        System.out.println("----------------------------------");
    }
}
