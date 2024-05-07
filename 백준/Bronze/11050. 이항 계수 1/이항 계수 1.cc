#include<iostream>

using namespace std;

int main(void)

{  
	int N, K,n,k;
	cin >> N >> K;
	if (K == 0 || K==N) {
		cout << "1";
		return 0;
	}
	if ((N - K) < K)K = N - K;
	n = N;
	k = K;
	int p = K;
	for (int i = 0; i < p-1;i++) {
		if (N == 1 || K == 1)break;
		n *= (N - 1);
		k *= (K - 1);
		N--;
		K--;

	}
	cout << n / k;


	return 0;
}