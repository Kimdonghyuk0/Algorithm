#include <iostream>
#include <algorithm>

using namespace std;
bool check[51];
int arr[51];
int sortedArr[51];
int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
		sortedArr[i] = arr[i];
	}
	sort(sortedArr, sortedArr + n);

	for (int i = 0; i < n; i++)
	{
		int target = arr[i];
		for (int j = 0; j < n; j++)
		{
			if (target == sortedArr[j] && !check[j]) {
				check[j] = true;
				cout << j << " ";
				break;
			}
		}
	}

	return 0;


}