#include <iostream>
#include "Employee.h"

using namespace std;

Employee::Employee(string firstName, string lastName, int salary)
    : firstName(firstName), lastName(lastName), salary(salary) {}

string Employee::getFirstName()
{
    return firstName;
}

void Employee::setFirstName(string firstName)
{
    this->firstName = firstName;
}

string Employee::getLastName()
{
    return lastName;
}

void Employee::setLastName(std::string)
{
    this->lastName = lastName;
}

int Employee::getSalary()
{
    return salary;
}

void Employee::setSalary(int salary)
{
    this->salary = salary > 0 ? salary : 0;
}

void Employee::displayEmployeeInfo()
{
    cout << "Employee " << getFirstName() << " " << getLastName() << " salary is " << getSalary() << " dollars." << endl;
}