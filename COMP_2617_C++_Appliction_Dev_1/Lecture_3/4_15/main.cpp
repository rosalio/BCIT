#include <iostream>
#include <iomanip>

using namespace std;

int main() {

    cout << fixed << setprecision(2) << showpoint;
    const double RATE = 0.09;
    const double BASE_SALARY = 200;

    double salesInDollars = 0;

    cout << "Enter sales in dollars (-1 to end): ";
    cin >> salesInDollars;

    while (salesInDollars != -1) {
        double salary = BASE_SALARY + salesInDollars * RATE;
        cout << "Salary is: $" << salary << endl;

        cout << "\nEnter sales in dollars (-1 to end): ";
        cin >> salesInDollars;
    }

    return 0;
}