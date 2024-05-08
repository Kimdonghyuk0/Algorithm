#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    stack<char>check;
    int N;
    int count;
    string inputLine;

    cin >> N;
    cin.ignore();
    for (int i = 0; i < N; i++) {
        count = 0;
        check = stack<char>();
      
        getline(cin, inputLine);

        
        for (char ch : inputLine) {
            check.push(ch);
        }

        while (!check.empty()) {
            if (check.top() == ')')count++;
            else count--;
            check.pop();
            if (count < 0) {
                cout << "NO" << "\n";
                break;
            }
            
        }
        if (count == 0)cout << "YES" << "\n";
        else if (count > 0) cout << "NO" << "\n";

    }
    return 0;
}
