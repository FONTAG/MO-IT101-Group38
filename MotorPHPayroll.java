import java.util.ArrayList;
import java.time.LocalTime;
import java.time.Duration;

public class MotorPH {
    public static void main(String[] args) {
        ArrayList<Employee> employeeList = new ArrayList<>();

        // Adding the MotorPH Employees
        employeeList.add(new Employee("10001", "Garcia", "Manuel III", "10/11/1983", 90000.0, 1500.0, 2000.0, 1000.0, 535.71));
        employeeList.add(new Employee("10002", "Lim", "Antonio", "06/19/1988", 60000.0, 1500.0, 2000.0, 1000.0, 357.14));
        employeeList.add(new Employee("10003", "Aquino", "Bianca Sofia", "08/12/1989", 60000.0, 1500.0, 2000.0, 1000.0, 357.14));
        employeeList.add(new Employee("10004", "Reyes", "Isabella", "06/16/1994", 60000.0, 1500.0, 2000.0, 1000.0, 357.14));
        employeeList.add(new Employee("10005", "Hernandez", "Eduard", "09/23/1989", 52670.0, 1500.0, 1000.0 , 1000.0, 313.51));
        employeeList.add(new Employee("10006", "Villanueva", "Andrea Mae", "02/14/1988", 52670.0, 1500.0, 1000.0, 1000.0, 313.51));
        employeeList.add(new Employee("10007", "San Jose", "Brad", "03/15/1996", 42975.0, 1500.0, 800, 800, 255.80));
        employeeList.add(new Employee("10008", "Romualdez", "Alice", "05/14/1992", 22500.0, 1500.0, 500, 500, 133.93));
        employeeList.add(new Employee("10009", "Atienza", "Rosie", "09/24/1948", 22500.0, 1500.0, 500, 500, 133.93));
        employeeList.add(new Employee("10010", "Gonzales", "Maria", "11/30/1987", 52670.0, 1500.0, 1000.0, 1000.0, 313.51));
        employeeList.add(new Employee("10011", "Salcedo", "Anthony", "09/14/1993", 50825.0, 1500.0, 1000.0, 1000.0, 302.53));
        employeeList.add(new Employee("10012", "Lopez", "Josie", "01/14/1987", 38475.0, 1500.0, 800, 800, 229.02));
        employeeList.add(new Employee("10013", "Farala", "Martha", "01/11/1942", 24000.0, 1500.0, 500, 500, 142.86));
        employeeList.add(new Employee("10014", "Martinez", "Leila", "07/11/1970", 24000.0, 1500.0, 500, 500, 142.86));
        employeeList.add(new Employee("10015", "Romualdez", "Fredrick", "03/10/1985", 53500.0, 1500.0, 1000.0, 1000.0, 318.45));
        employeeList.add(new Employee("10016", "Mata", "Christian", "10/21/1987", 42975.0, 1500.0, 800, 800, 255.80));
        employeeList.add(new Employee("10017", "De Leon", "Selena", "02/20/1975", 41850.0, 1500.0, 800, 800, 249.11));
        employeeList.add(new Employee("10018", "San Jose", "Allison", "06/24/1986", 22500.0, 1500.0, 500, 500, 133.93));
        employeeList.add(new Employee("10019", "Rosario", "Cydney", "10/06/1996", 22500.0, 1500.0, 500, 500, 133.93));
        employeeList.add(new Employee("10020", "Bautista", "Mark", "02/12/1991", 23250.0, 1500.0, 500, 500, 138.39));
        employeeList.add(new Employee("10021", "Lazaro", "Darlene", "11/25/1985", 23250.0, 1500.0, 500, 500, 138.39));
        employeeList.add(new Employee("10022", "Delos Santos", "Kolby", "02/26/1980", 24000.0, 1500.0, 500, 500, 142.86));
        employeeList.add(new Employee("10023", "Santos", "Vella", "12/31/1983", 22500.0, 1500.0, 500, 500, 133.93));
        employeeList.add(new Employee("10024", "Del Rosario", "Tomas", "12/18/1978", 22500.0, 1500.0, 500, 500, 133.93));
        employeeList.add(new Employee("10025", "Tolentino", "Jacklyn", "05/19/1984", 24000.0, 1500.0, 500, 500, 142.86));
        employeeList.add(new Employee("10026", "Gutierrez", "Percival", "12/18/1970", 24750.0, 1500.0, 500, 500, 147.32));
        employeeList.add(new Employee("10027", "Manalaysay", "Garfield", "08/28/1986", 24750.0, 1500.0, 500, 500, 147.32));
        employeeList.add(new Employee("10028", "Villegas", "Lizeth", "12/12/1981", 24000.0, 1500.0, 500, 500, 142.86));
        employeeList.add(new Employee("10029", "Ramos", "Carol", "08/20/1978", 22500.0, 1500.0, 500, 500, 133.93));
        employeeList.add(new Employee("10030", "Maceda", "Emelia", "04/14/1973", 22500.0, 1500.0, 500, 500, 133.93));
        employeeList.add(new Employee("10031", "Aguilar", "Delia", "01/27/1989", 22500.0, 1500.0, 500, 500, 133.93));
        employeeList.add(new Employee("10032", "Castro", "John Rafael", "02/09/1992", 52670.0,  1500.0, 1000, 1000, 313.51));
        employeeList.add(new Employee("10033", "Martinez", "Carlos Ian", "11/16/1990", 52670.0,1500.0, 1000, 1000, 313.51));
        employeeList.add(new Employee("10034", "Santos", "Beatriz", "08/07/1990", 52670.0, 1500.0, 1000, 1000, 313.51));

        int currentCutoff = 2; // If this was changed to 1, no statutory deductions would be applied. (1st cutoff)

        System.out.println("====== MotorPH Payroll Summary (Cutoff: " + currentCutoff + ") ======");
        
        for (Employee emp : employeeList) {
            // Calculating hours from Time In/Out instead of hardcoding 40
            // Example: 8:00 AM to 5:00 PM
            double hoursPerDay = emp.calculateDailyHours("08:00", "17:00");
            double totalHours = hoursPerDay * 5; // 40 hours for testing
            
            ddouble calculatedGross = emp.calculateGrossSalary(totalHours);
            double calculatedGross = emp.calculateGrossSalary(hoursWorked);
            
            // LOGIC: If it's the 1st cutoff, deductions are 0. If 2nd, use the formulas.
            double sss = (currentCutoff == 2) ? emp.calculateSSS() : 0.0;
            double philhealth = (currentCutoff == 2) ? emp.calculatePhilHealth() : 0.0;
            double pagibig = (currentCutoff == 2) ? emp.calculatePagIbig() : 0.0;
            double totalDeductions = sss + philhealth + pagibig;
            
            // Calculate the Tax (only if 2nd cutoff)
            double tax = (currentCutoff == 2) ? emp.calculateTax(calculatedGross, totalDeductions) : 0.0;
            
            double netPay = calculatedGross - totalDeductions - tax;

            System.out.println("ID: " + emp.getEmployeeNumber());
            System.out.println("Name: " + emp.getFullName());
            
            System.out.println("Monthly Basic: PHP " + emp.getBasicSalary());
            System.out.println("Gross Semi-monthly Rate: PHP " + emp.getGrossSemiMonthlyRate());
            System.out.printf("Hours Worked: %.2f hrs%n", totalHours);
            System.out.printf("Total Gross for 40hrs:  PHP %.2f%n" , calculatedGross);
            
            if (currentCutoff == 2) {
                System.out.printf("SSS: PHP %.2f | PhilHealth: PHP %.2f | Pag-IBIG: PHP %.2f%n", sss, philhealth, pagibig);
                System.out.printf("Withholding Tax: PHP %.2f%n", tax); // Add this line
            } else {
                System.out.println("Status: 1st Cutoff - No Statutory Deductions applied.");
            }
            
            System.out.printf("NET PAY: PHP %.2f%n", netPay);
            System.out.println("------------------------------------");
        }
    }
}
