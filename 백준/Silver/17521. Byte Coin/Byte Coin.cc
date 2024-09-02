#include <iostream>

using namespace std;

int bit[16];

int main() {
	int n, W;
	long long money;
	long long coin = 0;
	cin >> n >> W;
	money = W;
	for (int i = 1; i <= n; i++)
	{
		cin >> bit[i];
	}
	for (int i = 1; i <= n; i++)
	{
		if (i != n) {
		if (bit[i] < bit[i + 1]) { //매수 
			if(bit[i]<=money){
				coin = money / bit[i];
				money = money % bit[i];
			}
			
		}
	}
		if (i == n) {
			if (coin > 0) {
				money += coin * bit[i];
			}
		}
		else if (bit[i] > bit[i + 1]) {//매도
			if(coin>0){
				money += coin * bit[i];
				coin = 0;
			}
			
		}
	}
	cout << money;
}
