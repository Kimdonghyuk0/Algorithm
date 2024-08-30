#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	string s;
	cin >> s;
	int zero= 0;
	int one = 0;
	s += '9';

	for (int i = 0; i < s.length()-1; i++)
	{
		if (s[i] != s[i + 1]) {
			if (s[i] == '0')zero++;
			else one++;
		}
	}
	cout << min(zero, one);
	
}