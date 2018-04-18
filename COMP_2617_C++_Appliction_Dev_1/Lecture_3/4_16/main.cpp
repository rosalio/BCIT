#include <iostream>

using namespace std;

int main() {

    const double EXTRA_HOUR_RATE = 1.5;

    double hours = 0;

    cout << "Enter hours worked (-1 to end): ";
    cin >> hours;

    while(hours != -1) {
        cout << "Enter hourly rate of the employee ($00.00): ";
        double hourlyRate = 0;
        cin >> hourlyRate;
        double salary = hours <= 40 ? hourlyRate * hours : 40 * hourlyRate + (hours - 40) * hourlyRate * EXTRA_HOUR_RATE;
        cout << "Salary is $" << salary << endl;

        cout << "\nEnter hours worked (-1 to end): ";
        cin >> hours;
    }

    return 0;
}