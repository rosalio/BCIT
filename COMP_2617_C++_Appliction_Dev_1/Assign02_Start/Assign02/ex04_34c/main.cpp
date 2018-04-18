#include <iostream>
#include <iomanip>

using namespace std;

const int MAX_VALUE_OF_X = 709;
const int MIN_VALUE_OF_X = 1;
const double MIN_TERM_THRESHOLD = 1.0E-20;

int main() {

    // set up formatting for floating point values
    cout << setprecision(12);

    int xValue = 0; // variable to store input x

    cout << "Input a value for x between 1 and 709: ";
    cin >> xValue;

    while (cin.rdstate() || xValue > MAX_VALUE_OF_X ||
            xValue < MIN_VALUE_OF_X) {
        cin.clear();    // clear the error bit
        cin.ignore(INT_MAX, '\n');  // flush teh input buffer

        cout << "Input a value for x between 1 and 709: ";
        cin >> xValue;
    }

    double result = 0.0;    // sum of all terms
    double term = 1.0;  // each term

    unsigned int index = 0; // index of term
    while (term >= MIN_TERM_THRESHOLD) {
        if (index == 0) {
            term = 1.0; // assign value to first term
        } else {
            result += term; // add previous term to result
            term *= (1.0 * xValue / index); // calculate current term
        }
        ++index;
    }

    cout << "\ne raised to the " << xValue << " power is " << result <<
            endl;
    cout << "\nThe number of terms computed is " << index << endl;

    return 0;
}