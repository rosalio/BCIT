// Assignment 2 Solution: ex04_34b.cpp
// Solution for exercise 04_34b
//
// Alex (Xiaochen) Dai
// May 15, 2016

#include <iostream>
#include <iomanip>

using namespace std;

const int MAX_USER_INPUT = 13;
const int MIN_USER_INPUT = 5;

int main() {

    // set up formatting for floating point values
    cout << fixed << setprecision(11) << showpoint;

    int number = 0; // variable to store the input number of terms.

    cout << "The number of terms to compute is "
         << "(5 to 13 are valid values): ";
    cin >> number;

    while (cin.rdstate() || number > MAX_USER_INPUT ||
            number < MIN_USER_INPUT) {
        cin.clear();    // clear the error bit
        cin.ignore(INT_MAX, '\n');  // flush teh input buffer

        cout << "The number of terms to compute is "
             << "(5 to 13 are valid values): ";
        cin >> number;
    }

    double result = 0.0;
    unsigned long long factorial = 0;
    for (unsigned int index = 0; index < number; ++index) {
        if (index == 0) {
            factorial = 1;
        } else {
            factorial *= index;
        }
        result += 1.0 / factorial;
    }

    cout << "\nThe value of e is " << result << endl;

    return 0;
}