
class Date
{
public:
    explicit Date(int, int, int);
    int getMonth() const;
    void setMonth(int);
    int getDay() const;
    void setDay(int);
    int getYear() const;
    void setYear(int );
    void displayDate() const;

private:
    int month;
    int day;
    int year;
};