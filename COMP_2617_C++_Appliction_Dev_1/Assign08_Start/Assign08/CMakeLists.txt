cmake_minimum_required(VERSION 3.5)
project(Assign08)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES MainProg.cpp Complex.h Complex.cpp)
add_executable(Assign08 ${SOURCE_FILES})