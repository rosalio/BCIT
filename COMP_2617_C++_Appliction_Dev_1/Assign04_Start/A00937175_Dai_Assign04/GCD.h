// Assignment 4: GCD.h
// Implementation of gcd template function to
// find greatest common divisor
// Author:  Alex Dai
// Date: May 29th, 2016

#ifndef ASSIGN04_GCD_H
#define ASSIGN04_GCD_H

// template function gcd
template <typename T>
T gcd(T first, T second) {
    first = first >= 0 ? first : -first;
    second = second >= 0 ? second : -second;
    while (first != second) {
        if (first > second) {
            first -= second;
        } else {
            second -= first;
        }
    }
    return first;
}

#endif //ASSIGN04_GCD_H
