// Assignment 4: Fraction.cpp
// Member-function definitions for class Fraction.
// Author:  Alex Dai
// Date: May 29th, 2016

#include "Fraction.h"
#include "GCD.h" // template function for calculating greatest common divisor
#include <iostream>
using namespace std;

// default constructor
Fraction::Fraction() {
	numerator = 0;
	denominator = 1;
}

// second constructor
Fraction::Fraction(long long num, long long int denom) {
	numerator = num;
	denominator = denom;
	simplify();
}

// Implementation of the plusEq() member function
const Fraction & Fraction::plusEq(const Fraction & op) {
	numerator = numerator * op.denominator + denominator * op.numerator;
	denominator *= op.denominator;
	simplify();
	return (*this);
}

// Implementation of the minusEq() member function
const Fraction & Fraction::minusEq(const Fraction & op) {
	numerator = numerator * op.denominator - denominator * op.numerator;
	denominator *= op.denominator;
	simplify();
	return (*this);
}

//Implementation of the timesEq() member function
//Performs similar operation as the *= operator on the built-in types
const Fraction & Fraction::timesEq(const Fraction & op )
{
	numerator *= op.numerator;
	denominator *= op.denominator;

	simplify();  // will make sure that denominator is positive and
	             //   will invoke gcd() function to reduce fraction
	             //   as much as possible

	return (*this); // returns the object which invoked the method
}

// Implementation of the divideEq() member function
const Fraction & Fraction::divideEq(const Fraction & op) {
	numerator *= op.denominator;
	denominator *= op.numerator;

	simplify();

	return (*this);
}

// Implementation of the negate() member function
Fraction Fraction::negate() const {
	Fraction result(-numerator, denominator);
	return result;
}

// Get numerator
long long Fraction::getNum() const {
	return numerator;
}

// Get denominator
long long Fraction::getDenom() const {
	return denominator;
}

// Display the fraction
void Fraction::display() const {
	cout << numerator << "/" << denominator;
}

// Simplify the fraction
void Fraction::simplify() {
	long long divider = gcd<long long>(numerator, denominator);
	numerator /= divider;
	denominator /= divider;
	if (denominator < 0) { // make denominator positive
		denominator *= -1;
		numerator *= -1;
	}
}