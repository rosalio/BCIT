#include <iostream>

using namespace std;

bool multiple(int, int);

int main() {



    return 0;
}

bool multiple(int first, int second) {
    if (first == 0) {
        return second == 0 ? true : false;
    }

    return second % first == 0;
}