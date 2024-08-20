#include <iostream>

using namespace std;


int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    string str;
    cin >> str;
    char c=97;
    for (int i = 0; i < 26; i++)
    {
        bool flag = false;
        int count = 0;
        for (int j = 0; j < str.size(); j++)
        {
            if (str[j] == c)break;
            count++;
            if (j == str.size() - 1)flag = true;
        }
        if (flag)cout << "-1"<<" ";
        else cout << count << " ";
        c++;
    }

  
    return 0;
}