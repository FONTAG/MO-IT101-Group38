class Employee {
    // Basic Information
    private String employeeNumber;
    private String lastName;
    private String firstName;
    private String birthday;
    
    // Salary and Rates
    private double basicSalary;
    private double grossSemiMonthlyRate;
    private double hourlyRate;
    
    // Fixed Monthly Allowances (MotorPH specific)
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;

    // MotorPH Employee list
    public Employee(String empNum, String lName, String fName, String bday, 
                    double salary, double rice, double phone, double clothing, double hourly) {
        this.employeeNumber = empNum;
        this.lastName = lName;
        this.firstName = fName;
        this.birthday = bday;
        this.basicSalary = salary;
        this.basicSalary = salary;

        // Calculation for Gross Semi-monthly rate (even if not needed)
        this.grossSemiMonthlyRate = salary / 2;
        
        this.riceSubsidy = rice;
        this.phoneAllowance = phone;
        this.clothingAllowance = clothing;
        this.hourlyRate = hourly;
    }

    public double calculateSSS() {
        if (basicSalary <= 3250) return 135.00;
        if (basicSalary >= 24750) return 1125.00;
        return (Math.floor((basicSalary - 3250) / 500) * 22.50) + 157.50;
    }
    
    // Calculation Method for Gross Salary (Hours * Rate)
    public double calculateGrossSalary(double hoursWorked) {
        return hoursWorked * hourlyRate;
    }

    // Getters to access data later
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public double getTotalAllowances() {
        return riceSubsidy + phoneAllowance + clothingAllowance;
    }
    
    public double getBasicSalary() {
        return basicSalary;
    }
    public String getEmployeeNumber() {
        return employeeNumber;
    }
    public double getGrossSemiMonthlyRate() {
        return grossSemiMonthlyRate;
    }
    public String getBirthday() {
    return birthday;
    }
}
