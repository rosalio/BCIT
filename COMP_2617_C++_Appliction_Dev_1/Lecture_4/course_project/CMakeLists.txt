cmake_minimum_required(VERSION 3.5)
project(course_project)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES fig06_13.cpp)
add_executable(course_project ${SOURCE_FILES})