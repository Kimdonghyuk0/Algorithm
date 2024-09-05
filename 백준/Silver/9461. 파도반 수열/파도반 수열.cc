#include <iostream>

using namespace std;

long long dp[101];

int main() {
	int T,input;
	cin >> T;
	dp[1] = 1;
	dp[2] = 1;
	dp[3] = 1;
	dp[4] = 2;
	dp[5] = 2;
	for (int i = 6; i < 101; i++)
	{
		dp[i] = dp[i - 1] + dp[i - 5];
	}

	while(T--) {
		cin >> input;
		cout << dp[input]<<"\n";
	}

	return 0;
}