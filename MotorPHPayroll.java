public class MotorPH {
    public static void main(String[] args) {
        // 1. Using the real Employee blueprint we built
        Employee testEmp = new Employee("10001", "Crisostomo", "Jose", "01/01/1990", 
                                        62670.00, 1500.00, 1000.00, 1000.00, 373.04);

        // 2. Scenario: Let's test the 10-minute grace period rule
        int minutesLate = 15; // Change this to 5 to see it change to "ON TIME"
        double hoursWorked = 8.0; // Standard 8-hour shift
        
        System.out.println("------ MotorPH Payroll System ------");
        
        // 3. The Grace Period Logic (The "Condition" being asked for)
        if (minutesLate > 10) {
            System.out.println("Status: LATE (Deduction applied)");
            // If they are more than 10 mins late, we subtract that time.
            // 15 minutes is 0.25 of an hour.
            hoursWorked = hoursWorked - 0.25; 
        } else {
            System.out.println("Status: ON TIME / WITHIN GRACE PERIOD");
        }

        // 4. Calculate and display the results
        double grossPay = testEmp.calculateGrossSalary(hoursWorked);

        System.out.println("Employee Name: " + testEmp.getFullName());
        System.out.println("Final Gross Pay for today: PHP " + grossPay);
        System.out.println("------------------------------------");
    }
}
