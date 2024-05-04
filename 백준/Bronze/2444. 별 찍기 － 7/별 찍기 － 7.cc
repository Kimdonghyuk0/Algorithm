#include <iostream>
using namespace std;



int main()
{
	int N;
	cin >> N;
	int n = N-1;
	while (n != 0) {
		for (int i = 0; i < n; i++) {
			cout << " ";
		}
		for (int i = 0; i < (N-n); i++) {
			cout << "*";
		}
		for (int i = 0; i < (N - n)-1; i++) {
			cout << "*";
		}
		cout << endl;
		n--;
	}
	for (int i = 0; i < 2*N-1 ; i++) {
		cout << "*";
	}
	cout << endl;
	n++; //n==1
	while (n != N) {
		for (int i = 0; i < n; i++) {
			cout << " ";
		}
		for (int i = 0; i < (N-n); i++) {
			cout << "*";
		}
		for (int i = 0; i < (N - n) - 1; i++) {
			cout << "*";
		}
		cout << endl;
		n++;
	}

	return 0;
}