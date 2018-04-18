// Assignment 6 Solution: TurtleGraphics.h
// Declaration of class TurtleGraphics.
// Member functions are defined in TurtleGraphics.cpp.
// Author: Bob Langelaan 
// Date: Feb 28, 2016

#pragma once
#include <array>

// Define some enum types that will be used in solution

enum class Cmds : unsigned short { PEN_UP = 1, PEN_DWN = 2, TURN_RIGHT = 3, TURN_LEFT = 4, MOVE = 5, DISPLAY = 6, END_OF_DATA = 9 };
enum class Directions : unsigned short { NORTH, EAST, SOUTH, WEST };

class TurtleGraphics
{
private:
	const static size_t NROWS = 22;  // number of rows in floor
	const static size_t NCOLS = 70;  // number of colums in floor

	const static int STARTING_ROW = 0;    // row that turtle will start in
	const static int STARTING_COL = 0;    // column that turtle will start in

	const static Directions STARTING_DIRECTION = Directions::SOUTH; // direction 
	                      // that turtle will be facing at the start

	const static bool STARTING_PEN_POSITION = false; // Pen will be up when 
	                            // program starts
                                // false means pen up, true means pen down

	const static char VALUE_CHAR = '*'; // character to display when floor is 1
	const static char BLANK_CHAR = ' '; // display blank character when floor is 0

	void displayFloor() const;  // will display floor on the screen

	void turnRight(void);	// to turn right

	void turnLeft(void);	// to turn left

	void moveForward(int);	// to move forward

	std::array <std::array <bool, NCOLS>, NROWS> m_Floor;   // floor on which turtle will draw

	bool penPosition;	// current pen position
	Directions direction;	// current direction the turtle is facing
	int currentRow;	// current row of turtle
	int currentCol;	// current column of turtle

public:
	const static int ARRAY_SIZE = 250;

	TurtleGraphics(void); //ctor will init. floor to all "false" values, 
	                      //     as well as initialization of other data members
	void processTurtleMoves( const std::array< int, ARRAY_SIZE> &);  // will process
	                   // the commands contained in array "commands"

};


