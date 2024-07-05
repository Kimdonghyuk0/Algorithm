#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {

	int n;
	int h, m;
	int count;

	vector<pair<int, int>> v;

	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> h >> m;
		v.push_back(make_pair(h,m));
	}


	for (int i = 0; i < n; i++)
	{
		count = 0;
		for (int j = 0; j < n; j++)
		{
			if (v[i].first < v[j].first && v[i].second < v[j].second) {
				count++;
			}
		}
		
		 cout << count + 1<<" ";
	}

	return 0;


}