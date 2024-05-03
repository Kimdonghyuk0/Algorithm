#include <iostream>
#include <algorithm>

using namespace std;

bool checkDistance(int mid, int N, int C, int arr[]) {
	int count = 1; // 첫 번째 원소를 선택했다고 가정
	int last_selected = arr[0]; // 첫 번째 원소를 선택한 것으로 시작

	for (int i = 1; i < N; i++) {
		if (arr[i] - last_selected >= mid) { // 이전에 선택한 원소와의 거리가 mid 이상이면 선택
			last_selected = arr[i];
			count++;
			if (count == C) { 
				return true;
			}
		}
	}
	return false; 
}

int main() {
	int N, C;
	cin >> N >> C;

	int *arr = new int[N];
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
	int distance = 0;
	sort(arr, arr + N);
	int low = 1; //거리임
	int high = arr[N - 1] - arr[0];
	while (low <= high) {
		int mid = (high + low) / 2;
		if (checkDistance(mid, N, C, arr)) {
			distance = mid;
			low = mid + 1;
		}
		else high = mid - 1;
	}

	cout << distance << endl;
	delete[] arr;

	return 0;
}