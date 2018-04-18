#include <iostream>

using namespace std;

int main() {

    char firstStr[100];
    char secondStr[100];

    cout << "Please enter first string: ";
    cin.getline(firstStr, 100);
    cout << "Please enter second string: ";
    cin.getline(secondStr, 100);

    int lenFirst = strlen(firstStr);
    int lenSecond = strlen(secondStr);

    int result = strncmp(firstStr, secondStr, min(lenFirst, lenSecond));
    if (result == 0) {
        cout << "The two strings are equal." << endl;
    } else if (result > 0) {
        cout << "The first string is greater." << endl;
    } else {
        cout << "The second string is greater." << endl;
    }

    return 0;
}