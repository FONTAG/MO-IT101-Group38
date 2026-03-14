public class Employee {
    // Basic Information
    private String employeeNumber;
    private String lastName;
    private String firstName;
    private String birthday;
    
    // Constructor to fill in all the details from the MotorPH list
    public Employee(String empNum, String lName, String fName, String bday, 
                    double salary, double rice, double phone, double clothing, double hourly) {
        this.employeeNumber = empNum;
        this.lastName = lName;
        this.firstName = fName;
        this.birthday = bday;
        this.basicSalary = salary;
        this.riceSubsidy = rice;
        this.phoneAllowance = phone;
        this.clothingAllowance = clothing;
        this.hourlyRate = hourly;
    }

    // Calculation Method for Gross Salary (Hours * Rate)
    public double calculateGrossSalary(double hoursWorked) {
        return hoursWorked * hourlyRate;
    }

    // Getters to access data later
    public String getFullName() {
        return firstName + " " + lastName;
    }
