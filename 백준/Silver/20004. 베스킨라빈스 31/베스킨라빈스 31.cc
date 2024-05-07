#include<iostream>

using namespace std;

int main(void)

{  //후공이 이기는 경우 arr[i] = 1
	int arr[31] = { 0 };
	int a;
	cin >> a;

	for (int i = 0; i < 31; i++) {
		int k = 30;
		while (true) {
			k  = k - (i + 2);
			if (k <= 0) {
				k = k + (i + 2);
				break;
			}
		}
		if (k > i + 1)arr[i] = 1;
	}
	for (int i = 0; i < a;i++) {
		if(arr[i]==1)
		cout << i+1 << "\n";
	}

	return 0;
}