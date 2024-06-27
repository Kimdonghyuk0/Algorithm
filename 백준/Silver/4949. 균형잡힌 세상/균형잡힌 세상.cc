#include <iostream>
#include <string>
#include <stack>

using namespace std;


// s:() m:{} l:[]

int main() {
	stack<char> st;
	string str ;
	bool flag = true;
	while (true) {
		
		if (!str.empty())cin.ignore();
		getline(cin, str, '.');
		
		if (str.empty()) break;  

		flag = true;

		while (!st.empty()) { //스택초기화
			st.pop();	
		}

		for (int i = 0; i < str.size(); i++) {//문장검사
			
			
			
			if (str[i] == '(')st.push('(');
			else if (str[i] == ')') {
				if (st.empty()||st.top()!='(') {
					flag = false;
					break;
				}
				else if (st.top() == '(') {
					st.pop();
				}
			}
			else if (str[i] == '{')st.push('{');
			else if (str[i] == '}') {
				if (st.empty() || st.top() != '{') {
					flag = false;
					break;
				}
				else if (st.top() == '{') {
					st.pop();
				}
			}
				
			
			else if (str[i] == '[')st.push('[');
			else if (str[i] == ']') {
				if (st.empty() || st.top() != '[') {
					flag = false;
					break;
				}
				else if (st.top() == '[') {
					st.pop();
				}
			}
			
		}
		if (flag&&st.empty())cout << "yes"<<"\n";
		else cout << "no"<<"\n";

	}

	
	



 return 0;
}
