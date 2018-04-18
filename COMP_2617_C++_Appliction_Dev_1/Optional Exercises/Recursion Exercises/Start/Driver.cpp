
// Driver to test your 8 recursive functions
// Author: Bob Langelaan
// Date: April 20, 2015

#include <iostream>
#include <array>

using namespace std;

// 8 Function Prototypes
void sign(const int );

// NOTE: Because the next 2 prototypes are for template functions,
// their implementation needs to be appended to the end of this file
// and therefore cannot be put in a separate .cpp file instead.
template<typename type, size_t size> //template function
type addArray(const array<type,size> &, const int );

template<typename type,size_t size> //template function
bool isMember(const array<type,size> &, const int, const type );

unsigned long long combinations(unsigned long long y, unsigned long long x);
void decimalToBinary(const unsigned long long );
void ReverseString(const string &);

// The next 2 functions use C-style array rather than STL array
int Position(const int[], const int, const int);
void CountOdd(const int[], const int, int &);

//Main will test the 5 different recursive functions.

int main()
{
	// Testing part 1 - the sign() function

	cout << "PART 1";
	cout << "\nThe result of calling sign(4) is:\n";
	sign(4);

	//Testing part 2 - the addArray() function

	cout << "\n\nPART 2";
	array<double,10> array1 = {1.1,2.2,3.3,4.4,5.5,6.6,7.7,8.8,9.9,10.0};
	cout << "\nThe sum of the 10 values is: " << addArray(array1, array1.size());

	//Testing part 3 - the isMember() function

	cout << "\n\nPART 3";
	array<int,20> array2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	
	//Part 3 - Test 1
	if (isMember(array2, array2.size(), 15)) //Should return true
	{
		cout << "\nThe value 15 was found.";
	}
	else 
	{
		cout << "\nThe value 15 was not found.";
	}

	//Part 3 - Test 2
	if (isMember(array2, array2.size(), 45)) //Should return false
	{
		cout << "\n\nThe value 45 was found.";
	}
	else
	{
		cout << "\n\nThe value 45 was not found.";
	}
	
	//Testing part 4 - the combinations() function

	cout << "\n\nPART 4 (takes over 20 minutes to complete on my pc)";
	cout << "\nThe number of possible bridge hands is: " << combinations(52, 13);

    //Testing part 5 - the decimalToBinary() function

	cout << "\n\nPART 5";
	cout << "\nThe decimal value 245 converted to binary is: ";
	decimalToBinary(245);

	//Testing part 6 - the ReverseString() function

	cout << "\n\nPART 6";
	cout << "\nThe result of invoking ReverseString(\"How are you today?\"); is:\n";
	ReverseString("How are you today?");

	//Testing part 7 - the Position() function

	cout << "\n\nPART 7";
	const int ARRAY3_SIZE = 20;
	int array3[ARRAY3_SIZE] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

	//Part 7 - Test 1
	int pos;
	if ((pos = Position(array3, ARRAY3_SIZE, 15)) != 0) //Should return 15
	{
		cout << "\nThe value 15 was found at location: " << pos << endl;
	}
	else
	{
		cout << "\nThe value 15 was not found." << endl;
	}

	//Part 7 - Test 2
	if ((pos = Position(array3, ARRAY3_SIZE, 30)) != -1) //Should return 0
	{
		cout << "\nThe value 30 was found at location: " << pos << endl;
	}
	else
	{
		cout << "\nThe value 30 was not found." << endl;
	}

	//Testing part 8 - the CountOdd() function

	cout << "\n\nPART 8\n\n";
	int count;

	//Part 8 - Test 1
	const int ARRAY4_SIZE = 20;
	int array4[ARRAY4_SIZE] = { 2, 4, 6, 8, 10, 11, 14, 16, 18, 20, 21, 24, 26, 28, 30, 31, 34, 36, 38, 40 }; //11,21,31 odd

	count = 0;
	CountOdd(array4, ARRAY4_SIZE, count);
	if (count != 0) //Should return 3
	{
		cout << count << " odd numbers were found." << endl;
	}
	else
	{
		cout << "\nNo odd numbers were found." << endl;
	}

	//Part 8 - Test 2
	const int ARRAY5_SIZE = 20;
	int array5[ARRAY5_SIZE] = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 };// no odd

	count = 0;
	CountOdd(array5, ARRAY5_SIZE, count);
	if (count != 0) //Should return 3
	{
		cout << count << " odd numbers were found." << endl;
	}
	else
	{
		cout << "\nNo odd numbers were found." << endl;
	}

	cout << endl << endl;
	
	system("pause");
	return 0;
}


//Part 1
void sign(const int n)
{
	// You provide the rest
}

//Part 2
template<typename type, size_t size>
type addArray(const array<type,size> & myArray, const int n)
{
	// You provide the rest
}

//Part 3
template <typename type, size_t size>
bool isMember(const array<type,size> & myArray, const int n, const type value)
{
	// You provide the rest
}

//Part 4
unsigned long long combinations(unsigned long long y, unsigned long long x)
{
	// You provide the rest
}

//Part 5
void decimalToBinary(const unsigned long long n)
{
	// You provide the rest
}

//Part 6
void ReverseString(const string & myString)
{
	
}

//Part 7
int Position(const int inputArray[], const int size, const int value)
{
	// You provide the rest
}

//Part 8
void CountOdd(const int inputArray[], const int size, int & count)
{
	// You provide the rest
}