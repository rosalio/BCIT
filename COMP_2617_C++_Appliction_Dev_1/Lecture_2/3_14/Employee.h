#include <string>

class Employee
{
public:
    explicit Employee(std::string, std::string, int);
    std::string getFirstName();
    void setFirstName(std::string);
    std::string getLastName();
    void setLastName(std::string);
    int getSalary();
    void setSalary(int);
    void displayEmployeeInfo();
private:
    std::string firstName;
    std::string lastName;
    int salary;
};