#include <iostream>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int n, m;
	string word;
	vector<string> v;
	cin >> n >> m;
	map<string, int> map;
	for (int i = 0; i < n; i++)
	{
		cin >> word;
		map.insert({ word,1 });
	}
	int count = 0;
	for (int i = 0; i < m; i++)
	{
		cin >> word;
		if (map[word] == 1) {
			v.push_back(word);
			count++;
		}
	}
	sort(v.begin(), v.end());
	cout << count << "\n";
	for (int i = 0; i < v.size(); i++)
	{
		
		cout << v[i] << "\n";

	}
}