#include <iostream>

using namespace std;
long long arr[1001];

int main() {
	
	int n;
	cin >> n;
	arr[1] = 1;
	arr[2] = 2;
	for (int i = 3; i < 1001; i++)
	{
		
		arr[i] = (arr[i - 1] + arr[i - 2])%10007;
	}
	cout << arr[n];
	return 0;
}