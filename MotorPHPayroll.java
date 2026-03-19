import java.util.ArrayList;

public class MotorPH {
    public static void main(String[] args) {
        ArrayList<Employee> employeeList = new ArrayList<>();

        // Adding your employees
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
        System.out.println("====== MotorPH Payroll System ======");

        for (Employee emp : employeeList) {
            double hoursWorked = 40.0;
            int minutesLate = 12;

            if (minutesLate > 10) {
                hoursWorked = hoursWorked - 0.25;
            }

            double grossPay = emp.calculateGrossSalary(hoursWorked);

            System.out.println("ID: " + emp.getEmployeeNumber());
            System.out.println("Name: " + emp.getFullName());
            System.out.println("Gross Salary: PHP " + grossPay);
            System.out.println("------------------------------------");
        }
    }
}
