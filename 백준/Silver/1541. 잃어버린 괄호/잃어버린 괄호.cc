#include <iostream>
#include <string>

using namespace std;





int main() {
	
	string s;
	cin >> s;
	string number = "";
	int sum = 0;
	bool minus = false;
	for (int i = 0; i < s.size(); i++)
	{
		
		if (s[i] == '+'&&minus) {
		
			sum -= stoi(number);
			number = "";
		}
		else if (s[i] == '-'&&!minus) {
			minus = true;
			
			sum += stoi(number);
			number = "";
		}
		else if (s[i] == '+' && !minus) {
			minus = false;
			
			sum += stoi(number);
			number = "";
		}
		else if (s[i] == '-' && minus) {
			minus = true;
		
			sum -= stoi(number);
			number = "";
		}
		

		if(s[i]!='+'&&s[i]!='-')number += s[i];
		if(i==s.size()-1&&minus)sum -= stoi(number);
		else if (i == s.size() - 1 && !minus)sum += stoi(number);

	}
	cout << sum;

}