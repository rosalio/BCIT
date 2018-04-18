#include <iostream>

using namespace std;

void reverseString(char*);

int main() {

    char str[] = "(123) 456-7890";
    char *p;

    char result[10];

    printf ("Splitting string \"%s\" into tokens:\n", str);
    p = strtok (str," ()-");
    while (p != NULL)
    {
        strcat(result, p);
        p = strtok (NULL, " ,.-");
    }

    cout << result << endl;
    reverseString(result);

    cout << result << endl;

    return 0;
}

void reverseString(char* str) {
    int len = strlen(str);
    for (int i = 0; i < len / 2; ++i) {
        char c = str[i];
        str[i] = str[len - i - 1];
        str[len - i - 1] = c;
    }
}