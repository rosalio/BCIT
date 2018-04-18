// Assignment 6 Solution: TurtleGraphics.cpp
// Implementation of class TurtleGraphics.
// Author: Alex Dai
// Date: 6/23/2016

#include "TurtleGraphics.h"
#include <iostream>

using namespace std;

// constructor
TurtleGraphics::TurtleGraphics() {
    penPosition = STARTING_PEN_POSITION;
    direction = STARTING_DIRECTION;
    currentRow = STARTING_ROW;
    currentCol = STARTING_COL;

    for (auto& rows : m_Floor) {
        for (auto& elem : rows) {
            elem = false;
        }
    }
}

// turtle moves
void TurtleGraphics::processTurtleMoves(const std::array<int,
        ARRAY_SIZE> &command) {

    bool done = false;  // flag for end of data
    const int *currCmd = &command[0];

    while (!done) {
        switch (static_cast<Cmds>(*currCmd)) {
            case Cmds::PEN_UP:
                penPosition = false;
                ++currCmd;
                break;
            case Cmds::PEN_DWN:
                penPosition = true;
                ++currCmd;
                break;
            case Cmds::TURN_RIGHT:
                turnRight();
                ++currCmd;
                break;
            case Cmds::TURN_LEFT:
                turnLeft();
                ++currCmd;
                break;
            case Cmds::MOVE:
                moveForward(*(++currCmd));
                ++currCmd;
                break;
            case Cmds::DISPLAY:
                displayFloor();
                ++currCmd;
                break;
            case Cmds::END_OF_DATA:
                done = true;
                break;
            default:
                cout << "Invalid command in function processTurtleMoves!"
                << endl;
        }
    }

}

// turtle turn right
void TurtleGraphics::turnRight() {
    switch (direction) {
        case Directions::EAST:
            direction = Directions::SOUTH;
            break;
        case Directions ::NORTH:
            direction = Directions ::EAST;
            break;
        case Directions ::SOUTH:
            direction = Directions ::WEST;
            break;
        case Directions ::WEST:
            direction = Directions ::NORTH;
            break;
        default:
            cout << "Error when calling function turnRight()" << endl;
    }
}

// turtle turn left
void TurtleGraphics::turnLeft() {
    switch (direction) {
        case Directions::EAST:
            direction = Directions::NORTH;
            break;
        case Directions ::NORTH:
            direction = Directions::WEST;
            break;
        case Directions ::SOUTH:
            direction = Directions::EAST;
            break;
        case Directions ::WEST:
            direction = Directions::SOUTH;
            break;
        default:
            cout << "Error when calling function turnLeft()" << endl;
    }
}

// turtle moves forward
void TurtleGraphics::moveForward(int step) {
    int startRow = currentRow;
    int startCol = currentCol;
    int endRow, endCol;

    switch(direction) {
        case Directions::EAST:
            startCol = currentCol;
            // find ending column and do boundary check
            endCol = currentCol + step < NCOLS ? currentCol + step : NCOLS - 1;
            if (penPosition) {
                for (int col = startCol; col < endCol; ++col) {
                    m_Floor[currentRow][col] = true;
                }
            }
            currentCol = endCol;
            break;
        case Directions::WEST:
            startCol = currentCol;
            // find ending column and do boundary check
            endCol = currentCol - step >= 0 ? currentCol - step : 0;
            if (penPosition) {
                for (int col = startCol; col > endCol; --col) {
                    m_Floor[currentRow][col] = true;
                }
            }
            currentCol = endCol;
            break;
        case Directions::SOUTH:
            startRow = currentRow;
            // find ending row and do boundary check
            endRow = currentRow + step < NROWS ? currentRow + step : NROWS - 1;
            if (penPosition) {
                for (int row = startRow; row < endRow; ++row) {
                    m_Floor[row][currentCol] = true;
                }
            }
            currentRow = endRow;
            break;
        case Directions::NORTH:
            startRow = currentRow;
            // find ending row and do boundary check
            endRow = currentRow - step >= 0 ? currentRow - step : 0;
            if (penPosition) {
                for (int row = startRow; row > endRow; --row) {
                    m_Floor[row][currentCol] = true;
                }
            }
            currentRow = endRow;
            break;
        default:
            cout << "Error when calling function movingFormard!" << endl;
    }
}

// print floor
// 1: print a non-space characater (* in this case)
// 0: print a space
void TurtleGraphics::displayFloor() const {
    for (auto& rows : m_Floor) {
        for (auto& elem : rows) {
            elem ? cout << VALUE_CHAR : cout << BLANK_CHAR;
        }
        cout << endl;
    }
}