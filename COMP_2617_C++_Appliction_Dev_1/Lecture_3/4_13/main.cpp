#include <iostream>

using namespace std;

int main() {

    const double QUIT_DIGIT = -1;

    double totalMilesDriven = 0;
    double totalGallonsUsed = 0;

    double tripMiles = 0;
    double tripGallons = 0;

    cout << "Enter the miles used (-1 to quit): ";
    cin >> tripMiles;
    while(tripMiles != QUIT_DIGIT) {
        cout << "Enter gallons used: ";
        cin >> tripGallons;

        cout << "MPG this trip: " << tripMiles / tripGallons << endl;

        totalMilesDriven += tripMiles;
        totalGallonsUsed += tripGallons;
        cout << "Total MPG: " << totalMilesDriven / totalGallonsUsed << endl;

        cout << "\nEnter the miles used (-1 to quit): ";
        cin >> tripMiles;
    }


    return 0;
}