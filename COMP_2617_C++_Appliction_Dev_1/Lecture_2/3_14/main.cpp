#include <iostream>
#include "Employee.h"

using namespace std;

int main() {
    Employee employee1("John", "A", 100000);
    Employee employee2("Steve", "B", 120000);

    cout << "Current salary:" << endl;
    employee1.displayEmployeeInfo();
    employee2.displayEmployeeInfo();

    employee1.setSalary(employee1.getSalary() * 1.10);
    employee2.setSalary(employee2.getSalary() * 1.10);

    cout << "New salary:" << endl;
    employee1.displayEmployeeInfo();
    employee2.displayEmployeeInfo();

    return 0;
}