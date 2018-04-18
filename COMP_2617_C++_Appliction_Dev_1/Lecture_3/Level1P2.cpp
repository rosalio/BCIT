// This program demonstrates/tests Level 1 difficulty concepts
// from Chapters 4 & 5.

// PART 2

#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	// set up formatting for floating point values
	cout << fixed << setprecision(2) << showpoint;

	int testCount = 1;

	// Test #1
	cout << "Test #" << testCount++;

	cout << '\n';
	for (int i = 0; i < 10; ++i)
	{
		cout << i << "  ";
	}





	// Test #2
	cout << "\n\nTest #" << testCount++;

	int var5 = 0;

	cout << '\n';
	do {
		cout << var5 << "  ";
		++var5;
	} while (var5 < 10);





	// Test #3
	cout << "\n\nTest #" << testCount++;

	cout << '\n';

	for (int i = 0; i < 5; i++)
	{
		switch (i) {

		case 0: cout << "\nWe got to case 0"; break;

		case 1: cout << "\nWe got to case 1"; break;

		case 2: cout << "\nWe got to case 2"; break;

		case 3: cout << "\nWe got to case 3"; break;

		default: cout << "\nWe got to default case";

		}
	}


	// Test #4
	cout << "\n\nTest #" << testCount++;

	int count; 

	cout << '\n';
	for (count = 1; count <= 10; ++count)
	{
		if (5 == count) 
			break; 

		cout << count << " ";
	} 

	cout << "\nBroke out of loop at count = " << count << endl;

	// Test #5
	cout << "\n\nTest #" << testCount++;

	cout << '\n';
	for (int count = 1; count <= 10; ++count) 
	{
		if (count == 5) 
			continue;    

		cout << count << " ";
	} 


	// Test #6
	cout << "\n\nTest #" << testCount++;

	cout << boolalpha
		<< "\nfalse && false: " << (false && false)
		<< "\nfalse && true: " << (false && true)
		<< "\ntrue && false: " << (true && false)
		<< "\ntrue && true: " << (true && true) << "\n\n";

	cout << "\nfalse || false: " << (false || false)
		<< "\nfalse || true: " << (false || true)
		<< "\ntrue || false: " << (true || false)
		<< "\ntrue || true: " << (true || true) << "\n\n";

	cout << "\n!false: " << (!false)
		<< "\n!true: " << (!true) << endl;


	// Test #7
	cout << "\n\nTest #" << testCount++;

	int var6 = 0;
	cout << '\n';

	do{
		cout << '+' << ' ';
	} while (var6 = 0);

	cout << "\n\n";
}