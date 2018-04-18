#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

int main() {

    // a)

    int result = 0;
    for (int num = 1; num <= 99; num += 2) {
        result += num;
    }
    cout << "The sum of odd integers between 1 and 99 is " << result <<
            endl;

    // b)
    double number = 333.546372;

    cout << setw(15) << left << setprecision(1) << number << " ";
    cout << setw(15) << setprecision(2) << number << " ";
    cout << setw(15) << setprecision(3) << number << endl;

    // c)
    double base = 2.5;
    double pow_result = pow(base, 3);
    cout << "2.5 raise to the power 3 is " << setprecision(2) << fixed
        << setw(10) << pow_result << endl;

    // d)
    unsigned int x = 1;
    while (x <= 20) {
        cout << x << " ";
        if (x++ % 5 == 0) {
            cout << "\n";
        }
    }
    cout << endl;

    // e)
    for (unsigned int x = 1; x <= 20; ++x) {
        cout << x << " ";
        if (x % 5 == 0) {
            cout << "\n";
        }
    }
    cout << endl;


    return 0;
}