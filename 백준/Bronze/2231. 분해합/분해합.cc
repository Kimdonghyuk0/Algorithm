#include<iostream>
#include<string>
using namespace std;

int main(void)
{
	int length = 1;
	int pos = 0;
	int temp = 0;
	int num;
	cin >> num;
	int k = num;
	while (true) { //몇 자리 수인지 구하기
		if (k / 10 <= 0)break;
		k /= 10;
		length++;
	}
	
	for (int i = num - ((length - 1) * 9)-10; i < num; i++) {
		temp = i;
		k = 10;
		int n = 1;
		while (true) { // 모든 자리수 합
			if (k == 10) {
				temp = temp + i % k;
			}
			else temp = temp + i % k / n;
			k *= 10;
			n *= 10;
			if (i * 10 / k <= 0)break;
		}
		if (temp == num) {
			cout << i;
			return 0;
		}

		
	}
	cout << "0";
	return 0;
}