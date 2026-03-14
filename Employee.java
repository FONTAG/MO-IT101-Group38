public class Employee {
    private String employeeID;
    private String firstName;
    private String lastName;
    private double hourlyRate;

    public Employee(String id, String first, String last, double rate) {
        this.employeeID = id;
        this.firstName = first;
        this.lastName = last;
        this.hourlyRate = rate;
    }

    public double calculateGrossPay(double hoursWorked) {
        return hoursWorked * hourlyRate;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
