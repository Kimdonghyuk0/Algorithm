#include <iostream>
#include <algorithm>

using namespace std;

bool validLength(long long length,long long K, long long N, long long arr[]) {
	long long count = 0;
	for (int i = 0; i < K; i++) {
		
		count += arr[i]/length;
		if (count >= N)return true;
	}
	return false;
}

int main() {
	long long N, K;
	cin >> K >> N;
	long long* arr = new long long [K];
	long long maxLength = 0;
	for (int i = 0; i < K; i++) {
		cin >> arr[i];
	}
	sort(arr, arr + K);

	long long low = 1;
	long long high = arr[K - 1];
	
	while (low <= high) {
		long long mid = (low + high) / 2;
		
		if (validLength(mid, K, N, arr)) {
			maxLength = mid;
			low = mid + 1;
		}
		else high = mid - 1;

		
	}
	cout << maxLength << endl;
	delete[] arr;


	return 0;
}