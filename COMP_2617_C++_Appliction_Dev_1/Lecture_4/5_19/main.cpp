#include <iostream>
#include <cmath>

using namespace std;

int main() {

    double result = 0.0;
    int index = 1;

    while (index <= 1000) {
        if (index == 1) {
            result = 4;
        } else {
            result += pow(-1, index + 1) * 4 / (index * 2 - 1);
        }
        cout << "PI(" << index << ") = " << result << endl;
        index++;
    }

    return 0;
}