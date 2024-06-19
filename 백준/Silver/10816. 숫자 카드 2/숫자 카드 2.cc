#include <iostream>
#include <algorithm>
using namespace std;

int arr[500000];


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n,m,num;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    sort(arr, arr + n);
    cin >> m;
    for (int i = 0; i < m; i++) {
        cin >> num;
        cout << upper_bound(arr, arr + n, num) - lower_bound(arr, arr + n, num) << " ";
    }
   
        
    return 0;
}

