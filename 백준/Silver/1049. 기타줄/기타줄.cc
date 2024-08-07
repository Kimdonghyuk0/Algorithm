#include <iostream>
#include <vector>

using namespace std;



int main() {
	vector <pair<int, int>> v;
	int s, n;
	int ans = 0;
	cin >> s >> n;

	int a, b;
	int min1, min2;
	
	for (int i = 0; i < n; i++)
	{
		cin >> a >> b;
		v.push_back({a, b});
	}
	min1 = v[0].first;
	min2 = v[0].second;
	for (int i = 0; i < n; i++)
	{
		if (min1 > v[i].first)min1 = v[i].first;
		if (min2 > v[i].second)min2 = v[i].second;
	}
	if (min1 >= min2 * 6)ans = s * min2;
	else {
		if (s / 6 * min1 + s % 6 * min2 >= s / 6 * min1 + min1)ans = s / 6 * min1 + min1;
		else ans = s / 6 * min1 + s % 6 * min2;
	}
	cout << ans;


	return 0;
}