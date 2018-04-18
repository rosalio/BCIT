#include <string>

class GradeBook
{
public:
    explicit GradeBook(std::string, std::string);
    void setCourseName(std::string);
    std::string getCourseName() const;
    void setInstructorName(std::string);
    std::string getInstructorName() const;
    void displayMessage() const;

private:
    std::string courseName;
    std::string instructorName;
};