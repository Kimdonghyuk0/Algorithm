	#include <iostream>
	
	
	using namespace std;


	int main() {
		int t;
		int d;
		
		
		cin >> t;
		for (int i = 0; i < t; i++)
		{
			int num = 0;
			cin >> d;
			while (true) {
				if (num * num + num > d)break;
				num++;
			}
			cout << num - 1 << "\n";
			

		}

	 return 0;
	}
