#include <iostream>

using namespace std;

int sum[10001];
int main() {
	int N, M;
	int count = 0;
	cin >> N >> M;
	for (int i = 0; i < N; i++)
	{
		int num;
		cin >> num;
		for (int k = 0; k <= i; k++)
		{
			sum[k] += num;
			if (sum[k] == M) {
				count++;
			}
		}
	}
	cout << count;
}
