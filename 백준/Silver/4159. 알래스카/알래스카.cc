#include <iostream>

using namespace std;
bool charge[1423];

int main() {
	int n;
	
	
	while (true) {
		for (int i = 0; i < 1423; i++)
		{
			charge[i] = false;
		}
		charge[0] = true;
		int fuel = 200;
		bool flag = true;
		cin >> n;
		if (n == 0)break;

		for (int  i = 0; i < n; i++)
		{
			int input;
			cin >> input;
			charge[input] = true;

		}



		for (int i = 1; i < 1423; i++)
		{
			fuel--;
			if (fuel>=0&&charge[i])fuel = 200;
			if (fuel < 0) {
				cout << "IMPOSSIBLE" << "\n";
				flag = false;
				break;
			}
		}
		if (flag) {
			for (int i = 1421; i >= 0; i--)
			{
				fuel--;
				if (fuel >= 0 && charge[i])fuel = 200;
				if (fuel < 0) {
					cout << "IMPOSSIBLE" << "\n";
					flag = false;
					break;
				}
			}
		}
		if (flag)cout << "POSSIBLE" << "\n";

	}
}