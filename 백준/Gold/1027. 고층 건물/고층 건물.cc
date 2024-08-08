#include <iostream>
#include <vector>
#include <cmath>
using namespace std;


int arr[51];

int main() {
	int n;
	vector <pair<int, int>> v;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		int y;
		cin >> y;
		v.push_back({ i,y });
	}

	for (int i = 0; i < n; i++)
	{
		int count = 0;
		for (int j = 0; j < n; j++)
		{
			if (i == j)continue;
			if (v[i].first + 1 == v[j].first || v[i].first - 1 == v[j].first) {
				count++;
				continue;
			}
			for (int k = 0; k < n; k++)
			{
				bool flag = false;
				double value;
				if (i < k && k < j || j < k && k < i) {
					value = abs((static_cast<double>(v[j].second) - static_cast<double>(v[i].second)) /
						(static_cast<double>(v[j].first) - static_cast<double>(v[i].first)) *
						(static_cast<double>(v[k].first) - static_cast<double>(v[i].first)) +
						static_cast<double>(v[i].second));
					value = abs((static_cast<double>(v[j].second) - static_cast<double>(v[i].second)) /
						(static_cast<double>(v[j].first) - static_cast<double>(v[i].first)) *
						(static_cast<double>(v[k].first) - static_cast<double>(v[i].first)) +
						static_cast<double>(v[i].second));

					if (value > v[k].second)flag = true;
					if (!flag)break;
				}
				
				if (k == n - 1)count++;
			}


		}

		arr[i] = count;
	}
	int max = arr[0];
	for (int i = 0; i < n; i++)
	{
		
		if (max < arr[i])max = arr[i];
	}
	cout << max;

	return 0;
}