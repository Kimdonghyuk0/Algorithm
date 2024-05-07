#include<iostream>

using namespace std;
int arr[14];
int arrC[14];
int main(void)

{  
	int T, k , n;
	int sum = 0;
	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> k >> n;
		for (int q = 0; q < n; q++) {
			arr[q] = 1 + q;
			arrC[q] = 1 + q;
		}
		for (int j = 0; j < k; j++) {
			for (int q = 0; q < n; q++) {
				sum = 0;
				for (int p = 0; p <= q; p++) {
					sum += arrC[p];
				}
				arr[q] = sum;
			}
			for (int q = 0; q < 14; q++) {
				arrC[q] = arr[q];
		}
		}
		cout << arr[n-1] << "\n";
	}


	return 0;
}