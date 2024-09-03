#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;



vector<pair<int, int>> v;

bool compare(pair<int, int> n1, pair<int, int> n2) {
	if (n1.second == n2.second)
		return n1.first < n2.first;

	return n1.second < n2.second;
	
}
int main() {
	int n;
	cin >> n;
	int count = 0;
	for (int i = 0; i < n; i++)
	{
		int start, end;
		cin >> start >> end;
		v.push_back({ start, end });
		
	}
	sort(v.begin(), v.end(), compare);
	pair<int, int> now = { v[0].first,v[0].second };
	for (int i = 1; i < n; i++)
	{
		if (now.second <= v[i].first) {
			count++;  
			now = { v[i].first,v[i].second };
		}
	}
	cout << count+1;

	return 0;
}
