#include <iostream>
#include <string>

using namespace std;


bool number[10001];

int sumN(int n) {
	int sum = n;
	string s = to_string(n);
	for (int i = 0; i < s.size(); i++)
	{
		sum += s[i]-'0';
	}
	return sum;
}

int main() {
	int n = 1;
	
	for (int i = 1; i < 9990; i++)
	{
		int rs = sumN(i);
		if(rs<=10000)
		number[rs] = true;
	}
	for (int i = 1; i < 10001; i++)
	{
		if (!number[i])cout << i << "\n";
	}



}