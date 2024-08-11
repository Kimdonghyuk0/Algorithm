#include <iostream>

using namespace std;



int dp(int N, int M) {
	int arr[32][32] = { 0 };
	int ans = 0;
	for (int i = 1; i <= M-N+1; i++)
	{
		arr[1][i] = 1;
	}
	
		for (int i = 2; i <= N; i++)
		{
			for (int j = i; j <= M-N+i; j++)
			{
				for (int k = i-1; k <= j-1 ; k++)
				{
					arr[i][j] += arr[i - 1][k];
				}
			}
		}

		for (int i = N; i <= M; i++)
		{
			ans += arr[N][i];
		}

		return ans;

}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(NULL); cout.tie(NULL);
	
	int N, M, T;
	cin >> T;
	while (T--) {
		cin >> N >> M;
		cout << dp(N, M) << "\n";

	}
	

	return 0;
}