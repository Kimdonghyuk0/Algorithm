#include <iostream>
#include <string>

using namespace std;

int main() {
	string a;
	string b;
	int dif;
	int count = 0;
	int min = 1000000;
	cin >> a >> b;
	dif = b.length() - a.length();
	for (int i = 0; i < dif+1; i++)
	{
		count = 0;
		for (int j = 0; j < a.length(); j++)
		{
			if (a[j] != b[j+i])count++;
		}
		if (count < min)min = count;
	}
	cout << min;

	return 0;
}