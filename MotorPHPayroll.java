import java.util.ArrayList;
import java.time.LocalTime;
import java.time.Duration;
import java.io.File;
import java.util.Scanner;

public class MotorPHPayroll {
    public static void main(String[] args) {
        
        // ================= EMPLOYEE DATA LOADING =================
        // In a complete system, this should come from a CSV file.
        ArrayList<Employee> employeeList = loadEmployees();
        ArrayList<Attendance> attendanceList = loadAttendance("attendance.csv");

        // Cutoff selection:
        // 1 = No deductions
        // 2 = With deductions
        int currentCutoff = 2;

        System.out.println("====== MotorPH Payroll Summary (Cutoff: " + currentCutoff + ") ======");

        // ================= MAIN PAYROLL LOOP =================
        for (Employee emp : employeeList) {
        // OLD: hardcoded hours
        // double hoursPerDay = emp.calculateDailyHours("08:00", "17:00");
        // double totalHours = hoursPerDay * 5;

            // Step 1: Compute working hours based on time-in and time-out
            double totalHours = computeEmployeeHours(emp, attendanceList);

            // Step 2: Compute gross pay (hours × hourly rate)
            double calculatedGross = emp.calculateGrossSalary(totalHours);

            // Step 3: Add allowances (fixed monthly benefits)
            double grossPay = calculatedeGross + emp.getTotalAllowances();

            // Step 4: Compute deductions ONLY if 2nd cutoff
            double sss = (currentCutoff == 2) ? emp.calculateSSS() : 0.0;
            double philhealth = (currentCutoff == 2) ? emp.calculatePhilHealth() : 0.0;
            double pagibig = (currentCutoff == 2) ? emp.calculatePagIbig() : 0.0;

            double totalDeductions = sss + philhealth + pagibig;

            // Step 5: Compute tax (based on taxable income)
            double tax = (currentCutoff == 2) ? emp.calculateTax(grossPay, totalDeductions) : 0.0;

            // Step 6: Compute final net pay
            double netPay = grossPay - totalDeductions - tax;

            // Step 7: Display payroll summary
            printPayroll(emp, totalHours, grossPay, sss, philhealth, pagibig, tax, netPay, currentCutoff);
        }
    }

        // ================= LOAD ATTENDANCE =================
        // Method to load attendance from csv. Reads the attendance CSV and matches records to the employee.

        public static ArrayList<Attendance> loadAttendance(String fileName) {
            ArrayList<Attendance> list = new ArrayList<>();
            try {
                File file = new File(fileName);
                Scanner sc = new Scanner(file);
                if (sc.hasNextLine()) sc.nextLine();
                
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] data = line.split(",");
                    
                    list.add(new Attendance(data[0], data[1], data[2], data[3]));
                }
                
                sc.close();
            } catch (Exception e) {
                System.out.println("Error reading attendance file."); + e.getMessage());
            }
            return list;
        }
    // ===================== EMPLOYEE HOURS COMPUTATION =====================
    // Method to compute total hours for an employee. Sums up all hours from the attendance list for a specific employee.
    
    public static double computeEmployeeHours(Employee emp, ArrayList<Attendance> attendanceList) {
        double totalHours = 0;
        for (Attendance att : attendanceList) {
            if (att.getEmployeeNumber().equals(emp.getEmployeeNumber())) {
                totalHours += emp.calculateDailyHours(att.getTimeIn(), att.getTimeOut());
            }
        }
        
        return totalHours;
    }

    // Adding the MotorPH Employees
    // Loads employee data into an ArrayList.
    // In future versions, this should read from a CSV file.
     
    public static ArrayList<Employee> loadEmployees() {
        ArrayList<Employee> list = new ArrayList<>();

        // Format:
        // empNum, lastName, firstName, birthday, salary, rice, phone, clothing, hourlyRate
        list.add(new Employee("10001", "Garcia", "Manuel III", "10/11/1983", 90000.0, 1500.0, 2000.0, 1000.0, 535.71));
        list.add(new Employee("10002", "Lim", "Antonio", "06/19/1988", 60000.0, 1500.0, 2000.0, 1000.0, 357.14));
        list.add(new Employee("10003", "Aquino", "Bianca Sofia", "08/12/1989", 60000.0, 1500.0, 2000.0, 1000.0, 357.14));
        list.add(new Employee("10004", "Reyes", "Isabella", "06/16/1994", 60000.0, 1500.0, 2000.0, 1000.0, 357.14));
        list.add(new Employee("10005", "Hernandez", "Eduard", "09/23/1989", 52670.0, 1500.0, 1000.0 , 1000.0, 313.51));
        list.add(new Employee("10006", "Villanueva", "Andrea Mae", "02/14/1988", 52670.0, 1500.0, 1000.0, 1000.0, 313.51));
        list.add(new Employee("10007", "San Jose", "Brad", "03/15/1996", 42975.0, 1500.0, 800, 800, 255.80));
        list.add(new Employee("10008", "Romualdez", "Alice", "05/14/1992", 22500.0, 1500.0, 500, 500, 133.93));
        list.add(new Employee("10009", "Atienza", "Rosie", "09/24/1948", 22500.0, 1500.0, 500, 500, 133.93));
        list.add(new Employee("10010", "Gonzales", "Maria", "11/30/1987", 52670.0, 1500.0, 1000.0, 1000.0, 313.51));
        list.add(new Employee("10011", "Salcedo", "Anthony", "09/14/1993", 50825.0, 1500.0, 1000.0, 1000.0, 302.53));
        list.add(new Employee("10012", "Lopez", "Josie", "01/14/1987", 38475.0, 1500.0, 800, 800, 229.02));
        list.add(new Employee("10013", "Farala", "Martha", "01/11/1942", 24000.0, 1500.0, 500, 500, 142.86));
        list.add(new Employee("10014", "Martinez", "Leila", "07/11/1970", 24000.0, 1500.0, 500, 500, 142.86));
        list.add(new Employee("10015", "Romualdez", "Fredrick", "03/10/1985", 53500.0, 1500.0, 1000.0, 1000.0, 318.45));
        list.add(new Employee("10016", "Mata", "Christian", "10/21/1987", 42975.0, 1500.0, 800, 800, 255.80));
        list.add(new Employee("10017", "De Leon", "Selena", "02/20/1975", 41850.0, 1500.0, 800, 800, 249.11));
        list.add(new Employee("10018", "San Jose", "Allison", "06/24/1986", 22500.0, 1500.0, 500, 500, 133.93));
        list.add(new Employee("10019", "Rosario", "Cydney", "10/06/1996", 22500.0, 1500.0, 500, 500, 133.93));
        list.add(new Employee("10020", "Bautista", "Mark", "02/12/1991", 23250.0, 1500.0, 500, 500, 138.39));
        list.add(new Employee("10021", "Lazaro", "Darlene", "11/25/1985", 23250.0, 1500.0, 500, 500, 138.39));
        list.add(new Employee("10022", "Delos Santos", "Kolby", "02/26/1980", 24000.0, 1500.0, 500, 500, 142.86));
        list.add(new Employee("10023", "Santos", "Vella", "12/31/1983", 22500.0, 1500.0, 500, 500, 133.93));
        list.add(new Employee("10024", "Del Rosario", "Tomas", "12/18/1978", 22500.0, 1500.0, 500, 500, 133.93));
        list.add(new Employee("10025", "Tolentino", "Jacklyn", "05/19/1984", 24000.0, 1500.0, 500, 500, 142.86));
        list.add(new Employee("10026", "Gutierrez", "Percival", "12/18/1970", 24750.0, 1500.0, 500, 500, 147.32));
        list.add(new Employee("10027", "Manalaysay", "Garfield", "08/28/1986", 24750.0, 1500.0, 500, 500, 147.32));
        list.add(new Employee("10028", "Villegas", "Lizeth", "12/12/1981", 24000.0, 1500.0, 500, 500, 142.86));
        list.add(new Employee("10029", "Ramos", "Carol", "08/20/1978", 22500.0, 1500.0, 500, 500, 133.93));
        list.add(new Employee("10030", "Maceda", "Emelia", "04/14/1973", 22500.0, 1500.0, 500, 500, 133.93));
        list.add(new Employee("10031", "Aguilar", "Delia", "01/27/1989", 22500.0, 1500.0, 500, 500, 133.93));
        list.add(new Employee("10032", "Castro", "John Rafael", "02/09/1992", 52670.0,  1500.0, 1000, 1000, 313.51));
        list.add(new Employee("10033", "Martinez", "Carlos Ian", "11/16/1990", 52670.0,1500.0, 1000, 1000, 313.51));
        list.add(new Employee("10034", "Santos", "Beatriz", "08/07/1990", 52670.0, 1500.0, 1000, 1000, 313.51));
    
         return list;
    }
    
    //Prints payroll details of one employee.
    public static void printPayroll(Employee emp, double hours, double gross,
                                    double sss, double philhealth, double pagibig,
                                    double tax, double net, int cutoff) {

        System.out.println("ID: " + emp.getEmployeeNumber());
        System.out.println("Name: " + emp.getFullName());

        System.out.printf("Hours Worked: %.2f hrs%n", hours);
        System.out.printf("Gross Pay: PHP %.2f%n", gross);

        if (cutoff == 2) {
            System.out.printf("SSS: PHP %.2f | PhilHealth: PHP %.2f | Pag-IBIG: PHP %.2f%n",
                    sss, philhealth, pagibig);
            System.out.printf("Tax: PHP %.2f%n", tax);
        } else {
            System.out.println("No deductions applied (1st cutoff)");
        }

        System.out.printf("NET PAY: PHP %.2f%n", net);
        System.out.println("------------------------------------");
    }
}
