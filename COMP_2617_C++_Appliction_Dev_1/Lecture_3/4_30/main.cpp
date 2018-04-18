#include <iostream>

using namespace std;

int main() {

    const double PI = 3.14159;

    double radius = 0;
    cout << "Enter the radius of circle (-1 to quit): ";
    cin >> radius;

    while (radius != -1) {
        cout << "Diameter is: " << 2 * radius << endl;
        cout << "Circumference is: " << 2 * radius * PI << endl;
        cout << "Area is: " << PI * radius * radius << endl;

        cout << "\nEnter the radius of circle (-1 to quit): ";
        cin >> radius;
    }


    return 0;
}