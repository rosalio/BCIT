//
// Calculate gross pay, net pay, pension and deductions for employees
// of Rogers Hostpital Supplies Company.
//
// Alex Dai
// Jul 3, 2016
//

#include <iostream>
//#include <conio.h>  // Required for _getch() function
                      // comment out because not work in Mac OS
#include <fstream>  // Required for file input/output
#include <iomanip>

using namespace std;

//global constants

// One way to specify a file name:
const char * IN_FILE = "EmployeePayInput.txt";

// A second way to specify a file name:
#define OUT_FILE "EmployeePayOutput.txt"

const string COMPANY_NAME = "Rogers Hospital Supplies Company";

const double MAX_HOURS_WORKED = 54;	// max value allowed for hours worked
const double MAX_PAY_RATE = 99.99; // max value allowed for hourly pay rate
const int MAX_NUMBER_OF_EXEMPTIONS = 19; // max value of exemptions
const long MIN_SIN = 100000000; // minimum SIN allowed
const long MAX_SIN = 999999999; // maximum SIN allowed
const double REGULAR_PAY_HOURS = 40; // Threshold of regular pay hours
const double EXTRA_HOUR_PAY_RATE = 1.5; // Times of extra hourly pay rate

// Provincial income tax withholding rate based on federal income tax
const double PROV_FED_TAX_RATE = 0.35;

// Amount to be deducted for each hour of exemptions
const double AMOUNT_OF_EXEMPTIONS = 14;

// Amount to be deducted once from gross to caclulate the taxable
const double TAXABLE_ADJUST_AMOUNT = 11;

// Coefficients used to calculate federeal income tax withholding
const double FED_TAXABLE_COEFFICIENT_ONE = 0.14;
const double FED_TAXABLE_COEFFICIENT_TWO = 0.00023;

const double MIN_PENSION_RATE = 0.077; // Min of pension in rate
const double MIN_PENSION_AMOUNT = 16.50; // Min of pension in amount

// Function prototype: is pay rate valid
bool isValidPayRate(double);

// Function prototype: is hourly rate valid
bool isValidHoursWorked(double);

// Function prototype: is number of exemptions valid
bool isValidNumberOfExemptions(int);

// Function prototype: is SIN valid
bool isValidSocialInsuranceNum(long);

// Function prototype: calculate gross pay
double calculateGrossPay(double, double);

// Function prototype: calculate gross pay
double calculateDeductions(double, int);

// Function prototype:l calculate pension
double calculatePension(double);


int main()
{
	//Declare variables
	long socialInsuranceNum; // Store social security number of employee
	int numberOfExemptions; // Store number of exemptions for employee

	double payRate; // Store the pay rate for the employee
	double hoursWorked; // Store hours worked for the employee

	//Define ifstream object and open file
	ifstream ins;
	ins.open(IN_FILE);

	//Check that file opened without any issues
	if (ins.fail())
	{
		cerr << "ERROR--> Unable to open input file : " << IN_FILE << endl;
		cerr << '\n' << endl;
		getchar(); // causes execution to pause until a char is entered
		getchar();
		return -1; //error return code
	}

	//Define ofstream object and open file
	ofstream outs;
	outs.open(OUT_FILE);

	//Check that file opened without any issues
	if (outs.fail())
	{
		cerr << "ERROR--> Unable to open output file : " << OUT_FILE
		     << endl;
		cerr << '\n' << endl;
		getchar(); // causes execution to pause until a char is entered
		return -2; //error return code
	}

	// Print headers
	outs << COMPANY_NAME << "\n" << string(33, '-') << "\n\n";
	outs << left << setw(20) <<"Social insurance no.";
	outs << right << setw(12) << "gross pay";
	outs << right << setw(11) << "net pay";
	outs << right << setw(11) << "pension";
	outs << right << setw(15) << "deductions\n";
	outs << string(68, '-') << endl;

	int numOfEmployeesProcessed = 0;
	double totalGrossPay = 0;
	double totalNetPay = 0;
	double totalPension = 0;
	double totalDeductions = 0;

	// Read in first social security number
	ins >> socialInsuranceNum;

	// Process data until end of file is reached
	while (!ins.eof()){

		// Read in other data for the employee
		ins >> payRate >> numberOfExemptions >> hoursWorked;

		bool isValidInput = true; // Track if input is valid

		// Check if input SIN is valid
		if (!isValidSocialInsuranceNum(socialInsuranceNum)) {
			isValidInput = false;
			cerr << right << setw(10) << socialInsuranceNum;
			cerr << "\tINPUT DATA ERROR:\t";
			cerr << "Invalid social security #" << endl;
		}

		// Check if input pay rate is valid
		if (!isValidPayRate(payRate)) {
			isValidInput = false;
			cerr << right << setw(10) << socialInsuranceNum;
			cerr << "\tINPUT DATA ERROR:\t";
			cerr << "Invalid pay rate: " << fixed << setprecision(2)
			     << payRate << endl;
		}

		// Check if input number of exemptions is valid
		if (!isValidNumberOfExemptions(numberOfExemptions)) {
			isValidInput = false;
			cerr << right << setw(10) << socialInsuranceNum;
			cerr << "\tINPUT DATA ERROR:\t";
			cerr << "Invalid numbers of exemptions: "
			     << numberOfExemptions << endl;
		}

		// Check if input hours worked is valid
		if (!isValidHoursWorked(hoursWorked)) {
			isValidInput = false;
			cerr << right << setw(10) << socialInsuranceNum;
			cerr << "\tINPUT DATA ERROR:\t";
			cerr << "Invalid hours worked: " << fixed << setprecision(2)
			     << hoursWorked << endl;
		}

		// If the input in the same line is valid, start processing data
		if (isValidInput) {
			double grossPay = calculateGrossPay(payRate, hoursWorked);
			double deductions =
					calculateDeductions(grossPay, numberOfExemptions);
			double pension = calculatePension(grossPay);
			double netPay = grossPay - deductions - pension;

			outs << left << setw(20) << socialInsuranceNum;
			outs << right << setw(12) << fixed << setprecision(2)
			     << grossPay;
			outs << right << setw(11) << fixed << setprecision(2)
			     << netPay;
			outs << right << setw(11) << fixed << setprecision(2)
			     << pension;
			outs << right << setw(15) << fixed << setprecision(2)
			     << deductions << endl;

			++numOfEmployeesProcessed;
			totalGrossPay += grossPay;
			totalNetPay += netPay;
			totalPension += pension;
			totalDeductions += deductions;
		}

		// Read in next social security number
		ins >> socialInsuranceNum;
	}

	// print summary
	outs << "\n\n\nSummary\n" << string(7, '-') << "\n\n";
	outs << "Number of employees processed: \t\t\t" << right << setw(8)
	     << numOfEmployeesProcessed << "\n";
	outs << "Total gross pay for all employees: \t\t" << right << setw(8)
	     << fixed << setprecision(2) << totalGrossPay << "\n";
	outs << "Total net pay for all employees: \t\t" << right << setw(8)
	     << fixed << setprecision(2) << totalNetPay << "\n";
	outs << "Total pension withheld for all employees: \t" << right
	     << setw(8) << fixed << setprecision(2) << totalPension << "\n";
	outs << "Total deductions for all employees: \t\t" << right << setw(8)
	     << fixed << setprecision(2) << totalDeductions << endl;

	// Close files
	ins.close();
	outs.close();

	cout << '\n' << endl;

	// Remove following line of code (and this comment) from your solution
	cout << "Type any key to continue ... \n\n";

	getchar(); // causes execution to pause until char is entered

}

// Function: is hours worked valid
bool isValidHoursWorked(double hoursWorked) {
	return hoursWorked >= 0 && hoursWorked <= MAX_HOURS_WORKED;
}

// Function: is pay rate valid
bool isValidPayRate(double payRate) {
	return payRate >= 0 && payRate <= MAX_PAY_RATE;
}

// Function: is number of exemptions valid
bool isValidNumberOfExemptions(int numberOfExemptions) {
	return numberOfExemptions >= 0 &&
		   numberOfExemptions <= MAX_NUMBER_OF_EXEMPTIONS;
}

// Function: is SIN valid
bool isValidSocialInsuranceNum(long socialInsuranceNum) {
	return socialInsuranceNum >= MIN_SIN && socialInsuranceNum <= MAX_SIN;
}


// Function: Calculate gross pay
double calculateGrossPay(double payRate, double hoursWorked) {
	if (hoursWorked <= REGULAR_PAY_HOURS) {
		return payRate * hoursWorked;
	} else {
		return payRate * REGULAR_PAY_HOURS + payRate * EXTRA_HOUR_PAY_RATE
				* (hoursWorked - REGULAR_PAY_HOURS);
	}
}

// Function: Calculcate deductions
double calculateDeductions(double grossPay, int numberOfExemptions) {
	double taxable = grossPay - (AMOUNT_OF_EXEMPTIONS * numberOfExemptions)
					 - TAXABLE_ADJUST_AMOUNT;
	// if taxable is negative, set deductions to be 0
	if (taxable < 0) {
		return 0.0;
	}
	double federal = taxable * (FED_TAXABLE_COEFFICIENT_ONE +
					(FED_TAXABLE_COEFFICIENT_TWO * taxable));
	double provincial = PROV_FED_TAX_RATE * federal;
	return federal + provincial;
}

// Function: Calculate pension
double calculatePension(double grossPay) {
	double partialOfGrossPay = MIN_PENSION_RATE * grossPay;
	if (partialOfGrossPay > MIN_PENSION_AMOUNT) {
		return MIN_PENSION_AMOUNT;
	} else {
		return partialOfGrossPay;
	}
}