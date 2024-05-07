#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main(void)
{
	int N, M, num;
	int max = 0;
	cin >> N >> M;
	vector<int> v;
	for (int i = 0; i < N; i++) {
		cin >> num;
		if (num < M)v.push_back(num);
	}
	sort(v.begin(), v.end());

	for (int i = v.size() - 1; i >= 2; i--) {
		for (int j = i - 1; j >= 1; j--) {
			for (int k = j - 1; k >= 0; k--) {
				if (max< v.at(i) + v.at(j) + v.at(k)&&v.at(i) + v.at(j) + v.at(k) <= M) {
					max = v.at(i) + v.at(j) + v.at(k);
				}
			}
		}
	}
	cout << max;

	return 0;
}