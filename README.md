# MO-IT101-Group38
MotorPH Payroll System - Java Console Application

Member:
Fontanilla, Lyndle Flloyd A. 

Project Detail:
MotorPH Payroll System
----------------------------------------
A Java-based payroll application designed to automate the calculation of employee gross pay, deductions, and net salary based on attendance records.

This program computes the payroll of employees based on:
  - Hours worked
  - Hourly rate
  - Allowances
  - Government deductions (SSS, PhilHealth, Pag-IBIG)
  - Withholding tax
 
NOTE:
  - This version uses hardcoded data but is structured
  - to be easily upgraded to CSV-based input.

Features
----------------------------------------
 - CSV Integration: Automatically reads employee attendance data from attendance.csv.
 - Dynamic Calculations: Calculates hours worked, including handling of late arrivals and early departures.
 - Tax & Benefit Processing: (Optional: Mention if you have implemented SSS, PhilHealth, or Pag-IBIG logic).
 - Automated Payroll Generation: Processes data for all 34 employees simultaneously.

Setup & How to Run
----------------------------------------
 1. You can use any java complier app and site you have.
 2. Download the attendance csv (attendance.csv) file from the repository.
     - You can change the time in and time out of employees depending on your liking,then see how it affects the Payroll System.
 3. Compile all the java codes. To avoid confusion here's the arrangement on how would you paste the codes on the complier

    a. MotoroPHPayroll.java
    
     b. Employee.java
    
     c. Attendance.java
    
    Copy and paste everything on the complier following the same order and format.
 5. Upload or add the attendance.csv on the complier
 6. hit execute

SAMPLE RESULT: (see image below)
<img width="667" height="663" alt="image" src="https://github.com/user-attachments/assets/4539415a-72f1-436a-9dd3-304e8d83c598" />

Logic Overview & Data Architecture
----------------------------------------
1. Time Processing Logic
   - String-to-Time Parsing: The system uses java.time.LocalTime to convert CSV strings (e.g., "08:30") into temporal objects.
   - Duration Calculation: It calculates the elapsed time using Duration.between.
   - Lunch Break Deduction: To comply with Philippine labor laws, the system automatically deducts 1 hour (60 minutes) from the total daily duration to account for the mandatory unpaid break.
   - Negative Value Handling: A safety check ensures that if an employee's "Time Out" is before their "Time In" (or if total hours are less than the break), the work hours default to zero.

2. Statutory Deduction Engine
  The system follows the 2024 Philippine contribution schedules:
   - SSS: Calculated based on the Basic Salary bracket (ranging from PHP 135 to PHP 1,125).
   - PhilHealth: Calculated at 3% of the Basic Salary, divided by 2 (employee share).
   - Pag-IBIG: Set at 2% of the Basic Salary, capped at a maximum of PHP 100.00.

3. Withholding Tax Logic (TRAIN Law)
Tax is calculated on Taxable Income, which is derived as:
Taxable Income = (Gross Salary + Allowances) - (SSS + PhilHealth + Pag-IBIG).
The system applies the semi-monthly withholding tax brackets. If the taxable income is below the PHP 10,417 threshold, the tax is correctly output as 0.00.

Why 340 Rows of Input for the csv file?
----------------------------------------
  For this milestone, the attendance.csv was expanded to 340 rows (34 employees × 10 working days). This high volume of data was intentional for three reasons:
  1. Tax Threshold Validation: Using only 1 or 2 days of attendance results in a Gross Pay that falls below the BIR taxable threshold. By providing 10 days of randomized work hours, the Gross Pay reaches the PHP 10,417+ level, allowing us to verify that the Withholding Tax logic is functioning correctly.
  2. Stress Testing the Loop: It demonstrates the program’s capability to iterate through a large ArrayList of objects and match attendance logs to the correct Employee object using employeeNumber as a foreign key.
  3. Real-World Simulation: Randomizing the timeIn and timeOut values (e.g., 08:22 to 17:14) ensures the program handles non-standard hour totals (e.g., 7.84 hours) rather than just perfect 8-hour blocks.

Project Plan Link:
----------------------------------------
(https://docs.google.com/spreadsheets/d/1eTRyyKMNcQYswkWrers9bQGBLfWySobFUG-F4CnJ7uc/edit?usp=sharing)
