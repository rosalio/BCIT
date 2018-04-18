#include <iostream>

using namespace std;


int integerPower(int, unsigned int);

int main() {

    cout << "3^3 = " << integerPower(3, 3) << endl;
    cout << "-1^3 = " << integerPower(-1, 3) << endl;

    return 0;
}

/*
 * base: integer
 * exponent: nonzero positive integer
 */
int integerPower(int base, unsigned int exponent) {
    int result = 1;
    while (exponent-- != 0) {
        result *= base;
    }
    return result;
}