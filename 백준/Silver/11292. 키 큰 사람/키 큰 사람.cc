#include <iostream>

using namespace std;

string name[51];
double h[51];

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
   
    int T;
    while (true) {
        double max = 0;
        cin >> T;
        if (T == 0)return 0;
        for (int i = 0; i < T; i++)
        {
            cin >> name[i] >> h[i];
        }
        for (int i = 0; i < T; i++)
        {
            if (max < h[i])max = h[i];
        }
        for (int i = 0; i < T; i++)
        {
            if (max==h[i])cout<<name[i]<<" ";
        }

        cout << "\n";

    }
    
    return 0;
}