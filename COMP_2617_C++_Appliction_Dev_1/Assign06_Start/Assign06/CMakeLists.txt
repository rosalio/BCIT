cmake_minimum_required(VERSION 3.5)
project(Assign06)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES Assign6.cpp TurtleGraphics.cpp)
add_executable(Assign06 ${SOURCE_FILES})