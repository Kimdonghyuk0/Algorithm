#include <iostream>



using namespace std;


int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    int a;

    int arr[10001] = { 0 };

    for (int i = 1; i <= n; i++) {
        cin >> a;
        arr[a]++;
    }
    for (int i = 1; i <= 10000; i++) {
        for (int j = 0; j < arr[i]; j++) {
            cout << i << "\n";
       }
    }


    return 0;
}
