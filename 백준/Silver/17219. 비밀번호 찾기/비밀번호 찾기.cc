#include <iostream>
#include <unordered_map>

using namespace std;



int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n, m;
	cin >> n >> m;

	unordered_map<string, string> map;
	for (int i = 0; i < n; i++)
	{
		string site, pw;
		cin >> site >> pw;
		map.insert(make_pair(site, pw));
	}
	for (int i = 0; i < m; i++)
	{
		string target;
		cin >> target;
		auto it = map.find(target);
		cout << it->second<<"\n";
	}


	return 0;
}