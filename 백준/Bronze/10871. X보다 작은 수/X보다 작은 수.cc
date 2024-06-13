#include <iostream>

using namespace std;

int arr[10000];

int main() {

    ios_base::sync_with_stdio(false); // 동기화 비활성화

    cin.tie(NULL); // cin과 cout의 tie를 해제

    int N, X;

    cin >> N >> X;

    for (int i = 0; i < N; i++) {

        cin >> arr[i];

        if (X > arr[i]) cout << arr[i] << " ";

    }

    return 0;

}