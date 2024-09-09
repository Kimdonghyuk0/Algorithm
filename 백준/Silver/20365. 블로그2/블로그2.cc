#include <iostream>
#include <algorithm>
using namespace std;


int main() {
	int n;
	string input;
	char temp;
	int R = 0;
	int B = 0;

	cin >> n >>input;
	if (input[0] == 'B')B++;
	else R++;
	temp = input[0];
	for (int i = 1; i < n; i++)
	{
		if (input[i] != temp && input[i] == 'B')B++;
		else if (input[i] != temp && input[i] == 'R')R++;
		temp = input[i];
	}
	cout << min(R, B) + 1;

	return 0;
}