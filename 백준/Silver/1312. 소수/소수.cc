#include <iostream>

using namespace std;


int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    long long a, b, n, q, r;
    // q r 몫 나머지
    cin >> a >> b >> n;
    q = a / b;
    r = a % b;
    for (int i = 0; i < n; i++)
    {
        r *= 10;
        q = r / b;
        if (r < b)continue;

        else r = r % b;
    }
    cout << q;

  
    return 0;
}