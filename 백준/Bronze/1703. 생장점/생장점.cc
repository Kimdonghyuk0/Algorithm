#include <iostream>

using namespace std;



int main()
{

	int arr[40];
	int age;
	
	
	cin >> age;

	while (age != 0) {
		
		int result = 1;
		for (int i = 1; i < 2 * age+1; i++) {
			cin >> arr[i-1];
			if (i % 2 == 0)result -= arr[i - 1];
			else result *= arr[i - 1];
		}
		cout << result << endl;
		cin >> age;
	}

	return 0;
}