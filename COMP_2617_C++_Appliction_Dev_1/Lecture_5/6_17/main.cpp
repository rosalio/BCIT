#include <iostream>

using namespace std;

int main() {

    const int setOne[] = {2, 4, 6, 8, 10};
    const int setTwo[] = {3, 5, 7, 9, 11};
    const int setThree[] = {6, 10, 14, 18, 22};

    srand(static_cast<unsigned int>(time(NULL)));

    cout << "(1): " << setOne[rand() % 5] << endl;
    cout << "(2): " << setTwo[rand() % 5] << endl;
    cout << "(3): " << setThree[rand() % 5] << endl;

    return 0;
}