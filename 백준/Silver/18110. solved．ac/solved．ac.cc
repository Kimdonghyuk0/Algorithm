#include <iostream>
#include<cmath>
#include <deque>
#include <algorithm>

using namespace std;



int main() {
    ios::sync_with_stdio(false);
cin.tie(NULL);
    
	double n;
	int e; //제거해야할 사람수 위,아래 각각
	cin >> n;
	deque<int> dq;
	if (n == 0) {
		cout << "0";
		return 0;
	}

	e = round(n * 0.15);
	for (int i = 0; i < n; i++)
	{
		int num;
		cin >> num;
		dq.push_back(num);
	}
	sort(dq.begin(), dq.end());
	for (int  i = 0; i < e; i++)
	{
		dq.pop_back();
		dq.pop_front();
	}
	double sum = 0.0;
	for (int i = 0; i < dq.size(); i++)
	{
		sum += dq[i];
	}
	int result = round(sum / dq.size());
	cout << result;



	return 0;
}