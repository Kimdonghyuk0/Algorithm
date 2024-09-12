#include <iostream>
#include <map>
using namespace std;


int main() {
	int n;
	int max = -1;
	string s;
	cin >> n;
	map <string, int> map;
	for (int i = 0; i < n; i++)
	{
		string input;
		cin >> input;
		if (map.find(input) != map.end()) {
			map[input]++;
		}
		else {
			map[input] = 1;
		}
	}

	for (pair<string, int> p : map) {
		if (p.second > max) {
			max = p.second;
			s = p.first;
		}
	}
	cout << s;

	return 0;
}