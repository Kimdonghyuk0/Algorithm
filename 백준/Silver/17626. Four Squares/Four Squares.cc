#include <iostream>
#include <algorithm>

using namespace std;
int dp[50001];
int arr[240];

int main() {
	dp[1] = 1;
	dp[2] = 2;
	int n;
	cin >> n;
	//제곱수 채우기
	for (int i = 1; i <= 223; i++)
	{
		int sq = i * i;
		dp[sq] = 1;
		arr[i] = sq;
	}
	//1찾기 이후 더하기
	for (int i = 3; i < 50001; i++)
	{
		if (dp[i] == 1)continue;
		int min = dp[i-1]+1;
		for (int j = 1; j < 223; j++)
		{
			if (arr[j] >= i)break;
			if (min > dp[i - arr[j]] + 1)min = dp[i - arr[j]] + 1;
		}
		dp[i] = min;
	
	}
	cout << dp[n];

		
	return 0;
}