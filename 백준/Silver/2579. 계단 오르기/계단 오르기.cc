#include <iostream>

using namespace std;



int max(int a, int b) {
	if (a >= b)return a;
	else return b;
}

int dp[301][3];
int arr[301];

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(NULL); cout.tie(NULL);
	
	int N;
	cin >> N;

	arr[0] = 0;
	dp[0][0] = 0;
	dp[0][1] = 0;
	dp[0][2] = 0;
	int T = 1;
	for (int i = 1; i <= N; i++)
	{
		cin >> arr[i];
	}
	while (T <= N) {
		dp[T][0] = max(dp[T - 1][1], dp[T - 1][2]);
		dp[T][1] = dp[T - 1][0]+arr[T];
		dp[T][2] = dp[T - 1][1] + arr[T];

		T++;

	}
	cout << max(dp[N][1], dp[N][2]);

	return 0;
}