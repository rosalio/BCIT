// This program demonstrates/tests Level 3 difficulty concepts
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

	int var1 = 0;

	cout << '\n';
	while (var1 <= 10)
	{
		cout << (++var1)++ << ' ';
	}


	// Test #2
	cout << "\n\nTest #" << testCount++;

	cout << '\n';
	for (int i = 10, j = 20; (i > 0) && (j > 10); --i, --j)
	{
		cout << i << "  ";
	}


	// Test #3
	cout << "\n\nTest #" << testCount++;

	cout << '\n';

	for (int i = 5; i > 0; i--)
	{
		switch (i) {

		case 0: case 1:
			cout << "\nWe got to case 0 or 1";

		case 2: case 3:
			cout << "\nWe got to case 2 or 3";
			break;

		case 4: 
			cout << "\nWe got to case 4";
			break;

		}
	}












	// Test #4
	cout << "\n\nTest #" << testCount++;

	int count;

	cout << '\n';
	for (count = 1; count <= 10; ++count)
	{
		if ((8 == count) || (count == 5))
		{
			break;
		}

		if ((1 == count) || (count == 3))
		{
			continue;
		}

		cout << count << " ";
	}

	cout << "\nBroke out of loop at count = " << count << endl;

	cout << "\n\n";
}