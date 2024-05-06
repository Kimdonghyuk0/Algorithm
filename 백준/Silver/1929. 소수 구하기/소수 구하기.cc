#include<iostream>
#include<cmath>
using namespace std;

int arr[1000001];
int main(void)
{
	int n, m;
	cin >> n >> m;
	for (int i = 2; i <= m; i++)
		arr[i] = i;

	for (int i = 2; i <= sqrt(m); i++)		
	{
		if (arr[i] == 0)		
			continue;
		for (int j = i * i; j <= m; j += i)		
			arr[j] = 0;
	}

	for (int i = n; i <= m; i++)
	{
		if (arr[i] == 0)
			continue;
		else
			cout << arr[i] << '\n';
	}
	return 0;
}