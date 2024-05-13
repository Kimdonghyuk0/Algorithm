#include <iostream>

using namespace std;

bool arr[100][100];

int main() {
    int N;
    int x, y;
    cin >> N;
    int count = 0;
    for (int i = 0; i < N; i++) {
        cin >> x >> y;
        for (int j = x; j < x+10; j++) {
            for (int k = y; k < y+10; k++) {
                if(!arr[j][k])
                arr[j][k] = true;
            }
        }
    }
    for (int i = 0; i < 100; ++i) {
        for (int j = 0; j < 100; ++j) {
            if (arr[i][j]) {
                count++;
            }
        }
    }
    cout << count;
    return 0;
}
