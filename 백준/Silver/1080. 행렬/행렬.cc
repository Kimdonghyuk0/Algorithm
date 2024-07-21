#include <iostream>

using namespace std;
int arr1[54][54];
int arr2[54][54];
int dif[54][54];
int main() {
	int count = 0;
	int n,m;
	string s;
	
	cin >> n>>m;
	
	for (int i = 0; i < n; i++)
	{
		cin >> s;
		for (int j = 0; j < m; j++)
		{
			
			arr1[i][j] = s[j] - '0';
		}
	}	
	for (int i = 0; i < n; i++)
	{
		cin >> s;
		for (int j = 0; j < m; j++)
		{

			arr2[i][j] = s[j] - '0';
		}
	}





	for (int i = 0; i < n; i++)
	{
		
		for (int j = 0; j < m; j++)
		{

			if (arr1[i][j] == arr2[i][j])dif[i][j] = 0;
			else dif[i][j] = 1;
		}
	}
	
	while (true) {
		bool flag = false;
		bool finish = false;

		for (int i = 0; i < n; i++)
		{

			for (int j = 0; j < m; j++)
			{
				if (dif[i][j] == 1) {
					//3*3만큼 뒤집기
					for (int k = 0; k < 3; k++) {
						for (int q = 0; q < 3; q++)
						{
							if (dif[i + k][j + q] == 0)dif[i + k][j + q] = 1;
							else dif[i + k][j + q] = 0;
						}
					}

					flag = true;
					count++;
					break;
				}
				if (i == n - 1 && j == m - 1&& dif[i][j] == 0) {
					finish = true;

				}
			}
			if (flag)break;
			
		}
		//검사코드 >> 지정된 크기를 넘어서는 배열의 값이 1일경우 -1
		for (int i = 0; i < n; i++)
		{
			for (int j = m;  j < 54;  j++)
			{
				if (dif[i][j] == 1) {
					cout << -1;
					return 0;
				}
			}
		}
		for (int i = 0; i < m; i++)
		{
			for (int j = n; j < 54; j++)
			{
				if (dif[j][i] == 1) {
					cout << -1;
					return 0;
				}
			}
		}



		if (finish)break;
	}

	cout << count;


	return 0;
}