#include <iostream>
#include "Date.h"

using namespace std;

Date::Date(int month, int day, int year)
{
    setMonth(month);
    setDay(day);
    setYear(year);
}

int Date::getMonth() const
{
    return month;
}

int Date::getDay() const
{
    return day;
}

int Date::getYear() const
{
    return year;
}

void Date::setMonth(int month) {
    this->month = month >= 1 && month <= 12 ? month : 1;
}

void Date::setDay(int day)
{
    this->day = day;
}

void Date::setYear(int year)
{
    this->year = year;
}

void Date::displayDate() const
{
    cout << getMonth() << "/" << getDay() << "/" << getYear() << endl;
}