#include <iostream>
#include <string>

using namespace std;

int main() {
	int num;
	int count2 = 0;
	int count5 = 0;
	int temp = 0;
	cin >> num;

	if (num == 0) {
		cout << "0" << endl;
		return 0;
	}

	for (int i = 1; i <= num; i++) {
		temp = i;
		while (temp>=2 && temp % 2 == 0) {
			temp /= 2;
			count2++;
		}
		while (temp >= 2 && temp % 5 == 0) {
			temp /= 5;
			count5++;
		}
	}

	if (count2 > 0 && count5 > 0 && count5 < count2)cout << count5 << endl;
	else if (count2 > 0 && count5 > 0 && count5 > count2) cout << count2 << endl;
	else cout << "0" << endl;




	return 0;
}