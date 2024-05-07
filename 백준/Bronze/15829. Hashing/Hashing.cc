#include<iostream>
#include<string>
using namespace std;

int charToNumber(char c) {
	return c - 'a' + 1; 
}
int main(void)
{
	int L;
	long long result = 0;
	long long k = 1;
	long long M = 1234567891;
	char s;
	
	cin >> L;
	for (int i = 0; i < L; i++) {
		cin >> s;
		result = (result + charToNumber(s) * k % M)%M;
		 k = (k*31)%M;
	}
	cout << result;

	return 0;
}