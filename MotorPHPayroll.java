import java.util.ArrayList;

public class MotorPH {
    public static void main(String[] args) {
        // 1. Creating the ArrayList to hold our Employee objects
        ArrayList<Employee> employeeList = new ArrayList<>();

        // 2. We added employees from the MotorPH data
        // Format: (ID, Last, First, Birthday, Basic, Rice, Phone, Clothes, Hourly)
        employeeList.add(new Employee("10001", "Garcia", "Manuel III", "10/11/1983", 90000.0, 1500.0, 2000.0, 1000.0, 535.71));
        employeeList.add(new Employee("10002", "Lim", "Antonio", "06/19/1988", 60000.0, 1500.0, 2000.0, 1000.0, 357.14));
        employeeList.add(new Employee("10003", "Aquino", "Bianca Sofia", "08/12/1989", 60000.0, 1500.0, 2000.0, 1000.0, 357.14));
        employeeList.add(new Employee("10004", "Reyes", "Isabella", "06/16/1994", 60000.0, 1500.0, 2000.0, 1000.0, 357.14));

        System.out.println("====== MotorPH Payroll System ======");
        
        // 3. Loop through each employee in the list
        for (Employee emp : employeeList) {
            double hoursWorked = 40.0; // Let's assume a standard 40-hour week
            int minutesLate = 12;      // Example: Testing the 10-minute rule
            
            // Apply Grace Period Logic
            if (minutesLate > 10) {
                // If more than 10 mins late, we deduct 0.25 hours (15 mins) as a penalty
                hoursWorked = hoursWorked - 0.25;
            }

            double grossPay = emp.calculateGrossSalary(hoursWorked);

            // Print the details for each person
            System.out.println("ID: " + emp.getEmployeeNumber());
            System.out.println("Name: " + emp.getFullName());
            System.out.println("Gross Salary: PHP " + grossPay);
            System.out.println("------------------------------------");
        }
    }
}
