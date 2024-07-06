#include <iostream>
#include <cmath>	
#include <algorithm>
#include <vector>

using namespace std;

int arr[500001];
int mode[8002];


int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    
	vector<int> v;
	int n;
	cin >> n;
	double sum = 0.0;
	int max = -4001;
	int min = 4001;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
		sum += arr[i];
		if (max < arr[i])max = arr[i];
		if (min > arr[i])min = arr[i];
		mode[arr[i] + 4000]++;
	}
	double result1;
	result1 = sum / n;
	if (round(result1) == -0)cout << "0" << "\n";
	else
	cout << round(result1)<<"\n";
	sort(arr, arr+n);
	int k = n / 2;
	cout << arr[k] << "\n";

	int m = 0;
	int j; // mode[j]가 최빈값임
	for (int i = 0; i < 8002; i++) {
		if (m < mode[i])m = mode[i];
	}
	for (int i = 0; i < 8002; i++) {
		if (m == mode[i])v.push_back(i);
	}
	sort(v.begin(), v.end());
	if(v.size() >= 2)
	cout << v[1]-4000<<'\n';
	else cout << v[0] - 4000 << '\n';
	cout << max - min;




	return 0;
}