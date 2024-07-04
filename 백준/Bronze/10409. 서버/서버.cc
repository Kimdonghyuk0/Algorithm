	#include <iostream>
	
	using namespace std;

	int arr[50];

	int main() {
		int n, t;
		int sum = 0;
		int count = 0;
		cin >> n >> t;
		for (int i = 0; i < n; i++)
		{
			cin >> arr[i];
			sum += arr[i];
			if (sum <= t)count++;
			else break;
			
		}
		cout << count;

	 return 0;
	}
