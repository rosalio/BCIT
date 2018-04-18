// Assignment 2 Solution: ex04_34a.cpp
// Solution for exercise 04_34a
//
// Alex (Xiaochen) Dai
// May 15, 2016

#include <iostream>

using namespace std;

const int MAX_USER_INPUT = 20;
const int MIN_USER_INPUT = 0;

// function to calculate the factorial given a non-negative integer
unsigned long long calculateFactorial(unsigned int number) {
    if (0 == number || 1 == number) {
        return 1;
    }

    long long result = 1;
    while (number != 0) {
        result *= number--;
    }

    return result;
}

int main() {
    int number = 0; // variable to store an integer

    cout << "Enter a positive integer less than or equal to 20: ";
    cin >> number;  // obtain user input

    while (cin.rdstate() || number > MAX_USER_INPUT || number < MIN_USER_INPUT) { // check input
        cin.clear();    // clear the error bit
        cin.ignore(INT_MAX, '\n');  // flush teh input buffer

        cout << "Enter a positive integer less than or equal to 20: ";
        cin >> number;
    }

    // get factorial by calling "calculateFactorial" function
    unsigned long long factorial = calculateFactorial(number);
    cout << "\n" << number << "! is " << factorial << endl;

    return 0;
}
