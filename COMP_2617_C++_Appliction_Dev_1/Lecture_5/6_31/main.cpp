#include <iostream>

using namespace std;

int gcd(int, int);

int main() {

    cout << "-6 and 9 : " << gcd(-6, 9) << endl;
    cout << "24 and 60 : " << gcd(24, 60) << endl;

    return 0;
}

int gcd(int first, int second) {
    first = first >= 0 ? first : -first;
    second = second >=0 ? second : -second;
    while(first != second) {
        if(first > second) {
            first -= second;
        } else {
            second -= first;
        }
    }

    return first;
}