cmake_minimum_required(VERSION 3.5)
project(Assign04)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES MainProg.cpp GCD.h Fraction.cpp Fraction.h)
add_executable(Assign04 ${SOURCE_FILES})