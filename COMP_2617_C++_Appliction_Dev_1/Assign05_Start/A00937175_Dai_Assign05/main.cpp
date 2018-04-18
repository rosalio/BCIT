// Assignment 5 Solution: main.cpp
// Solution for exercise 07_13
//
// Alex (Xiaochen) Dai
// Jun 10, 2016

#include <iostream>
#include <array>
#include <iomanip>

using namespace std;

const int SIZE_OF_ARRAY = 20;   // size of array to store input
const int MAX_INPUT_NUM = 100;  // maximum input value allowed
const int MIN_INPUT_NUM = 10;   // minimum input value allowed

// check if input is within range
bool isNumberWithinRange(int);

// check if input number is unique
bool isUnique(int, const array<int, SIZE_OF_ARRAY>&);

// print the result to screen
void printResult(const array<int, SIZE_OF_ARRAY>&);

int main() {
    // declare and initialize the array
    array<int, SIZE_OF_ARRAY> numArray = {0}; //

    int input = 0;  // to store user input
    cout << endl;
    for (int index = 1; index <= SIZE_OF_ARRAY; ++index) {
        cout << "Enter # " << index << " : ";
        cin >> input;

        // check if user input is valid
        while (cin.rdstate() || !isNumberWithinRange(input)) {
            cin.clear();
            cin.ignore(INT_MAX, '\n');
            cout << "The number entered is not in the valid range"
                 << "of 10 to 100" << endl << endl;
            cout << "Enter # " << index << " : ";
            cin >> input;
        }

        // if user input is unique, store it in the array
        // and print out to screen
        if (isUnique(input, numArray)) {
            numArray[index - 1] = input;
            cout << "The number: " << input << " is unique" << endl;
        }
        cout << endl;
    }

    // print the array
    printResult(numArray);

    return 0;
}

// function to check if user input is within range
bool isNumberWithinRange(int number) {
    return number >= MIN_INPUT_NUM && number <= MAX_INPUT_NUM;
}

// function to check if user input is unique
bool isUnique(int num, const array<int, SIZE_OF_ARRAY> &arr) {
    for (const auto& s : arr) {
        if (s == num) {
            return false;
        }
    }
    return true;
}

// print the array in a certain format
void printResult(const array<int, SIZE_OF_ARRAY> &arr) {
    cout << "\nThe unique numbers are: " << endl << endl;
    int displayed = 0;  // store how many number has been displayed
    for (const auto& s : arr) {
        if (s != 0) {   // skip 0, which means duplicate number
            cout << setw(6) << s;
            if (++displayed % 5 == 0) { // change line every 5 numbers
                cout << endl;
            }
        }
    }
    cout << endl;
}