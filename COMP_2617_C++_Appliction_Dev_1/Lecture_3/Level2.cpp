// This program demonstrates/tests Level 2 difficulty concepts
// from Chapters 4 & 5.

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

	double d = 2.0;
	double d2 = 2.0;

	cout << '\n';
	cout << (d == 2.0 ? (d2 == 3.0 ? "Result #1" : "Result #2") : (d2 == 3.0 ? "Result #3" : "Result #4"));





	// Test #2
	cout << "\n\nTest #" << testCount++;

	int var1 = 1;

	cout << '\n';
	while (var1 <= 10)
		cout << var1++ << ' ';






	// Test #3
	cout << "\n\nTest #" << testCount++;

	cout << '\n';
	for (int i = 0; i < 10; ++i)
	{
		cout << i << "  ";
	}






	// Test #4
	cout << "\n\nTest #" << testCount++;

	int var5 = 0;

	cout << '\n';
	do {
		cout << var5++ << "  ";
	} while (var5 < 10);


	// Test #5
	cout << "\n\nTest #" << testCount++;

	cout << '\n';

	for (int i = 5; i >= 0; i--)
	{
		switch (i) {

		case 0: cout << "\nWe got to case 0";

		case 1: cout << "\nWe got to case 1"; 
			    break;

		case 2: cout << "\nWe got to case 2";

		case 3: cout << "\nWe got to case 3"; 
			    break;

		default: cout << "\nWe got to default case";

		}
	}












	// Test #6
	cout << "\n\nTest #" << testCount++;

	int count;

	cout << '\n';
	for (count = 1; count <= 10; ++count)
	{
		if (8 == count)
		{
			break;
		}

		if (5 == count)
		{
			continue;
		}

		cout << count << " ";
	}

	cout << "\nBroke out of loop at count = " << count << endl;












	// Test #7
	cout << "\n\nTest #" << testCount++;

	cout << '\n';
	for (int count = 1; count <= 10; ++count) 
	{
		if (count == 5)
		{
			continue;
		}

		if (count == 9)
		{
			continue;
		}

		if (count == 7)
		{
			continue;
		}

		cout << count << " ";
	} 







	// Test #8
	cout << "\n\nTest #" << testCount++;

	cout << boolalpha
		<< '\n' << ((false && true) && (true && false))
		<< '\n' << ((true && true) && (true || false)) << "\n\n";

	cout << ((false && true) || (true && true))
		<< '\n' << ((false || true) || (true && false))
		<< '\n' << !(((true && true) || (false || false )))
		<< '\n' << !(((true || false) || (true || false)));

	cout << "\n\n";
}