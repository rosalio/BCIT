cmake_minimum_required(VERSION 3.5)
project(3_14)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp Employee.h Employee.cpp)
add_executable(3_14 ${SOURCE_FILES})