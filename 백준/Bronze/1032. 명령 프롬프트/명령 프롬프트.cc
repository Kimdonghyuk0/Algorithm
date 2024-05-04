#include <iostream>
#include <string>
\
using namespace std;



int main()
{
	int N;
	cin >> N;
	char temp = ' ';
	string* arr = new string[N];
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
	for (int i = 0; i < arr[0].size(); i++) {
		for (int k = 0; k < N; k++) {
		char c = arr[k][i];
		if(k==0) temp = c;
		if (c != temp) {
			cout << "?";
			break;
		}
		else if (k == N - 1) {
			cout << c;
		}
	}

	}
	
	

	delete []arr;
	return 0;
}