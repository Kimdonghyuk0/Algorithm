#include <iostream>
#include<string>
using namespace std;


int main() {
    int A, B, C, result;
    cin >> A >> B >> C;
    result = A * B * C;
    string str = to_string(result);
    for (int i = 0; i < 10; i++) {
        int count = 0;
        for (int j = 0; j < str.size(); j++) {
            if (str[j] == '0'+i)count++;

        }
        if (i == 0)cout << count<<"\n";
        else {
            cout << count << "\n";
        }
    }

    return 0;
}
