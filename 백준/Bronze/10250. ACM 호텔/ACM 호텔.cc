#include <iostream>

using namespace std;

int check(int h,int w,int n) {
    int hh, ww;
    if (n % h == 0)hh = h;
    else hh = n % h;
    if (n % h == 0)ww = n / h;
    else ww = n / h + 1;
    return hh * 100 + ww;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int T,h,w,n;
    cin >> T;
    while (T--) {
        cin >> h >> w >> n;
        cout << check(h, w, n)<<"\n";
    }
  
    return 0;
}