// Ex3_11.cpp
// GradeBook class demonstration after separating 
// its interface from its implementation.
#include <iostream>
#include "GradeBook.h" // include definition of class GradeBook

using namespace std;

// function main begins program execution
int main()
{
    // create two GradeBook objects
    GradeBook gradeBook1( "CS101 Introduction to C++ Programming","Bob Langelaan" );
    GradeBook gradeBook2( "CS102 Data Structures in C++","George Formen");

    // display initial value of courseName and instructorName for each GradeBook
    gradeBook1.displayMessage();
    gradeBook2.displayMessage();

    return 0; // indicate successful termination
} // end main



/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 **************************************************************************/
