#include <iostream>

using namespace std;



int main() {
	int n;
	int p1, p2;
	int count = 0;

	cin >>n>>p1>>p2;
	while (true) {
		count++;
		if (p1 % 2 == 0 && p2 == p1 - 1 || p2 % 2 == 0 && p1 == p2 - 1)break;
		if (count > n) {
			cout << "-1";
			break;
		}
		if (p1 % 2 == 0)p1 /= 2;
		else if (p1 % 2 != 0)p1 = p1 / 2 + 1;
		if (p2 % 2 == 0)p2 /= 2;
		else if (p2 % 2 != 0)p2 = p2 / 2 + 1;
		
	}
	cout << count;

	return 0;
}