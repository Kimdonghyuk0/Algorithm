#include <iostream>

using namespace std;


int dp[1000001];

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n,div2,div3,sub1;
   
    cin >> n;
    dp[0] = 0;
    dp[1] = 0;
    dp[2] = 1;
    dp[3] = 1;

    for (int i = 4; i < 1000001; i++)
    {
        div2 = 1000000;
        div3 = 1000000;
        sub1 = 1000000;
        if (i % 2 == 0) {
            div2 = dp[i / 2] + 1;
        }
        if (i % 3 == 0) {
            div3 = dp[i / 3] + 1;

        }
        sub1 = dp[i - 1] + 1;


        dp[i] = div2;
        if (div3 < dp[i]) {
            dp[i] = div3;
        }
        if (sub1 < dp[i]) {
            dp[i] = sub1;
        }

    }
    cout << dp[n];
    
  
    return 0;
}