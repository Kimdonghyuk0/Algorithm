#include <iostream>

using namespace std;




int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n,t,p;
    int arr[6];
    int print1;
    print1 = 0;
    cin >> n;
    for (int i = 0; i < 6; i++) {
        cin >> arr[i];
       
    }
    cin >> t >> p;
    for (int i = 0; i < 6; i++) {
       
        if ((arr[i] % t) != 0)print1 += (arr[i] / t) + 1;
        else print1 += (arr[i] / t);
    }
    cout << print1 << "\n";
    cout << n / p << " " << n % p;
    return 0;
}
