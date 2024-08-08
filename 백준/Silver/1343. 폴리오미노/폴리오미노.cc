#include <iostream>
#include <string>
using namespace std;


int temp[50];

int main() {
    ios::sync_with_stdio(false);
cin.tie(nullptr);
cout.tie(nullptr);
	string str;
	string a = "AAAA";
	string b = "BB";
	int count = 0;
	cin >> str;

	for (int i = 0; i < str.length(); i++)
	{

		if (str[i] == '.' || i == (str.length() - 1)) {
			if (i == (str.length() - 1) && str[i] != '.')count++;
			if (count % 4 == 1 || count % 4 == 3) {
				cout << "-1";
				return 0;
			}
			

			if (str[i] == '.') {
				count = 0;
				
			}
		}
		else {
			count++;
		}
	}
	count = 0;
	for (int i = 0; i < str.length(); i++)
	{

		if (str[i] == '.'||i==(str.length()-1)) {
			if (i == (str.length() - 1) && str[i] != '.')count++;
			if (count % 4 == 1 || count % 4 == 3) {
				cout << "-1";
				return 0;
			}
			else {
				for (int j = 0; j < count/4; j++)
				{
					cout << a;
				}
				for (int j = 0; j < count % 4/2; j++)
				{
					cout << b;
				}
			}

			if (str[i] == '.') {
				count = 0;
				cout << ".";
			}
		}
		else {
			count++;
		}
	}

	


	return 0;
}