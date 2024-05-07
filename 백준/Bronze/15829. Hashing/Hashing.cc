#include<iostream>
#include<string>
using namespace std;

int charToNumber(char c) {
	return c - 'a' + 1; 
}
int main(void)
{
	int L;
	int result = 0;
	int k = 1;
	char s;
	
	cin >> L;
	for (int i = 0; i < L; i++) {
		cin >> s;
		result+=charToNumber(s)*k;
		k *= 31;
	}
	cout << result;

	return 0;
}