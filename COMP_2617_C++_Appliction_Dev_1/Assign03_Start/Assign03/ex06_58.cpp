// Assignment 3 Solution: ex06_58.cpp
// Solution for exercise 06_58
//
// Alex (Xiaochen) Dai
// May 20, 2016

#include <iostream>

using namespace std;

const int QUIT_NUMBER = -1;     // -1 to quit program.
const unsigned int SCALE = 10;  // scale factor to generate integer 0-9
const unsigned int NUM_OF_CORRECT_MESSAGES = 4; // correct message number
const unsigned int NUM_OF_INCORRECT_MESSAGES = 4; // incorrect msg number

unsigned int getNumber(unsigned int);// get a random non-negative integer
void multiplication();  // implementation of multiplication
void correctMessage();  // display message when the answer is correct
void incorrectMessage(); // display message when the answer is incorrect

int main() {
    srand(static_cast<unsigned int>(time(NULL)));
    multiplication();

    return 0;
}

// Generate a random non-negative integer, given the scale factor
unsigned int getNumber(unsigned int scale) {
    return rand() % scale;
}

// Implementation of multiplication
void multiplication() {
    int userAnswer = 0;
    unsigned int firstNumber = getNumber(SCALE);
    unsigned int secondNumber = getNumber(SCALE);
    cout << "Enter " << QUIT_NUMBER << " to End." << endl;
    cout << "How much is " << firstNumber << " times " << secondNumber
         << " (" <<QUIT_NUMBER << " to End)? ";
    cin >> userAnswer;

    // Check if input contains invalid characters
    while (cin.rdstate()) {
        cin.clear();
        cin.ignore(INT_MAX, '\n');
        cout << "Invalid input entered - try again: ";
        cin >> userAnswer;
    }

    // loop to check user input and display responses
    while(userAnswer != QUIT_NUMBER) {
        unsigned int correctAnswer = firstNumber * secondNumber;
        if (userAnswer == correctAnswer) {  // answer is correct
            correctMessage();
            firstNumber = getNumber(SCALE);
            secondNumber = getNumber(SCALE);
            cout << endl << "How much is " << firstNumber << " times "
                 << secondNumber << " (" <<QUIT_NUMBER << " to End)? ";
        } else { // answer is incorrect
            incorrectMessage();
            cout << "? ";
        }

        cin >> userAnswer;
        while (cin.rdstate()) {
            cin.clear();
            cin.ignore(INT_MAX, '\n');
            cout << "Invalid input entered - try again: ";
            cin >> userAnswer;
        }
    }

    cout << "That's all for now. Bye." << endl;
}

// Display message when the answer is correct
void correctMessage() {
    switch (getNumber(NUM_OF_CORRECT_MESSAGES)) {
        case 0:
            cout << "Very good!" << endl;
            break;
        case 1:
            cout << "Excellent!" << endl;
            break;
        case 2:
            cout << "Nice work!" << endl;
            break;
        case 3:
            cout << "Keep up the good work" << endl;
            break;
    }
}

// Display message when the answer is incorrect
void incorrectMessage() {
    switch (getNumber(NUM_OF_INCORRECT_MESSAGES)) {
        case 0:
            cout << "No. Please try again." << endl;
            break;
        case 1:
            cout << "Wrong. Try once more." << endl;
            break;
        case 2:
            cout << "Don't give up!" << endl;
            break;
        case 3:
            cout << "No. Keep trying." << endl;
            break;
    }
}