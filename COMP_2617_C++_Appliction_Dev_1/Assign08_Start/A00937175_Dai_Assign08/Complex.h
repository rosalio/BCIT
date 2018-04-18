//
// Complex class interface
// Perform arithmetic with complex numbers
//
// Created by Dai, Alex on 7/11/16.
//

#ifndef ASSIGN08_COMPLEX_H
#define ASSIGN08_COMPLEX_H

// Complex class interface
class Complex {
private:
    double realPart;    // store real part
    double imaginaryPart;   // store imaginary part

public:
    // constructor
    Complex(const double realPart = 1, const double imaginaryPart = 0);

    // get real part
    double getRealPart() const;

    // set real part
    void setRealPart(const double);

    // get imaginary part
    double getImaginaryPart() const;

    // set imaginary part
    void setImaginaryPart(const double);

    // display the complex number
    void display(void) const;

    // complex number plus operation
    Complex& plusEq(const Complex &);

    // complex number minus operation
    Complex& minusEq(const Complex &);
};

#endif //ASSIGN08_COMPLEX_H
