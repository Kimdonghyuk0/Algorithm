#include <iostream>
#include <cmath>

using namespace std;

bool checkPrimeNumber(int num) {
    if (num == 1) return false;
    if (num == 2) return true;
    if (num % 2 == 0) return false;

    for (int i = 3; i <= sqrt(num); i += 2) {
        if (num % i == 0) return false;
    }

    return true;
}

int main() {
    int M, N;
    cin >> M >> N;

    int size = N - M + 1;
    bool* prime = new bool[size];
    for (int i = 0; i < size; ++i) {
        prime[i] = true;
    }

    if (M == 1) {
        prime[0] = false;
    }

  
    int limit = static_cast<int>(sqrt(N)) + 1;
    for (int i = 2; i < limit; ++i) {
        if (checkPrimeNumber(i)) {
            int start = max(i * i, (M + i - 1) / i * i);
            for (int j = start; j <= N; j += i) {
                prime[j - M] = false;
            }
        }
    }

    for (int i = 0; i < size; ++i) {
        if (prime[i]) {
            cout << M + i << "\n";
        }
    }

    delete[] prime;

    return 0;
}
