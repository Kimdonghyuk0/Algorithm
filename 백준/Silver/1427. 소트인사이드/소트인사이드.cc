  #include <algorithm>
#include <string>
#include <iostream>

using namespace std;

bool compare(char i, char j) {
    return j < i; }


int main() {
    string s;
    cin >> s;

    sort(s.begin(), s.end(), compare); 

    for(int i = 0; i < s.length(); i++) {
        cout << s[i];
    }
}