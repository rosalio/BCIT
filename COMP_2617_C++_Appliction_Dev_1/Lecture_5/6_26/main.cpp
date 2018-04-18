#include <iostream>
#include <iomanip>

using namespace std;

double celsius(double);
double fahrenheit(double);

int main() {
    cout << fixed << setprecision(1);

    cout << "Celsius" << " --- " << "Fahrenheit" << endl;
    for (double degree = 0.0; degree <= 100.0; degree+=1.0) {
        cout << degree << " --- " << fahrenheit(degree) << endl;
    }

    cout << endl << endl;

    cout << "Fahrenheit" << " --- " << "Celcius" << endl;
    for (double degree = 32.0; degree <= 212.0; degree+=1.0) {
        cout << degree << " --- " << celsius(degree) << endl;
    }

    return 0;
}

inline double celsius(double degreeInFahrenheit) {
    return (degreeInFahrenheit - 32) * 5.0 / 9;
}

inline double fahrenheit(double degreeInCelsius) {
    return degreeInCelsius * 9.0 / 5 + 32;
}