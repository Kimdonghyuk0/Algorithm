#include <iostream>
#include <string>
using namespace std;

string arr[1001];

int main() {
	int n;
	string lastN;
	int count = 1;
	bool check = true;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}
	while (true) {
		check = true;
		
		
		for (int j = 0; j <= n-2; j++)
		{
			lastN = arr[j].substr(arr[0].length() - count, count);
			for (int i = j+1; i <= n-1; i++)
			{
				if (lastN == arr[i].substr(arr[0].length() - count, count)) {
					check = false;
					break;
				}
			}
			if (!check)break;
		}
		

		if (check)break;
		count++;
	}
	cout << count;

	return 0;
}