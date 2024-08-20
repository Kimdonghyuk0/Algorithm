#include <iostream>

using namespace std;

int check(string str) {
    int total, score;
    total = 0;
    score = 0;
    for (int i = 0; i < str.size(); i++)
    {
        if (str[i] == 'O') {
            score++;
            total += score;

        }
        else score = 0;
    }
    return total;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int T;
    string str;
    cin >> T;
    while (T--) {
        cin >> str;
        cout<<check(str)<<'\n';
    }
  
    return 0;
}