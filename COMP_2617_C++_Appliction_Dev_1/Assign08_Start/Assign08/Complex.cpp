//
// Complex class implementation
// Perform arithmetic with complex numbers
//
// Created by Dai, Alex on 7/11/16.
//

#include <iostream>
#include <iomanip>
#include "Complex.h"

using namespace std;

// constructor
Complex::Complex(const double realPart, const double imaginaryPart) {
    setRealPart(realPart);
    setImaginaryPart(imaginaryPart);
}

// get real part
double Complex::getRealPart() const {
    return realPart;
}

// set real part
void Complex::setRealPart(const double realPart) {
    this->realPart = realPart;
}

// get imaginary part
double Complex::getImaginaryPart() const {
    return imaginaryPart;
}

// set imaginary part
void Complex::setImaginaryPart(const double imaginaryPart) {
    this->imaginaryPart = imaginaryPart;
}

// display the complex number
void Complex::display() const {
    cout << fixed << setprecision(4) << "( " << getRealPart() << " , "
         << getImaginaryPart() << " )";
}

// complex number plus operation
Complex& Complex::plusEq(const Complex & numberToPlus) {
    this->realPart += numberToPlus.getRealPart();
    this->imaginaryPart += numberToPlus.getImaginaryPart();
    return *this;
}

// complex number minus operation
Complex& Complex::minusEq(const Complex & numberToMinus) {
    this->realPart -= numberToMinus.getRealPart();
    this->imaginaryPart -= numberToMinus.getImaginaryPart();
    return *this;
}