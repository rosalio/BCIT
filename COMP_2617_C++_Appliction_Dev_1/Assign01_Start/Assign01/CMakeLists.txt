cmake_minimum_required(VERSION 3.5)
project(Assign01)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES ex03_12.cpp Account.h Account.cpp)
add_executable(Assign01 ${SOURCE_FILES})