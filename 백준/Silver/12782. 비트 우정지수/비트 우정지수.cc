#include <iostream>
#include <string>
using namespace std;

int main() {
	int n;
	cin >> n;
	string a, b;
	
	
	for (int i = 0; i < n; i++)
	{
		int dif = 0;
		int acount = 0;
		int bcount = 0;
		int difc;
		cin >> a >> b;
		for (int j = 0; j < a.length(); j++)
		{
			if (a[j] != b[j])dif++;
			if (a[j] == '1')acount++;
			if (b[j] == '1')bcount++;
		}
		if (acount > bcount)difc = acount - bcount;
		else difc = bcount - acount;
		cout << (dif-difc) / 2 + difc<<"\n";
	}


	return 0;
}