#include <iostream>
#include <string>

using namespace std;

int main() {
    string str;
    int count = 1;
    getline(cin, str);
    for (int i = 0; i < str.size(); i++) {
        if (str[i] == ' ')count++;
    }
    if (str[0] == ' ')count--;
    if (str[str.size()-1] == ' ')count--;
    cout << count << endl;

    return 0;
}
