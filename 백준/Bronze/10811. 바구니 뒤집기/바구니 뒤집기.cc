#include <iostream>
#include <algorithm>
using namespace std;

int arr[101];
int temp[101];
int main()
{
	int n, m, i , j;
	cin>>n>>m;
	
	for(int i = 0; i < n; i++)
	{
	arr[i]=i+1;	
		
	}
	
		for(int k = 0; k < m; k++)
	{
		cin>>i>>j;
			for(int t = 0; t<j-i+1; t++){
				
				temp[t]=arr[j-1-t];
				
			}
			for(int t = 0; t<j-i+1; t++){
				arr[i-1+t] = temp[t];	
			}
	}
	
		for(int i = 0; i < n; i++)
	{
	cout<<arr[i]<<" ";
	
	}
	
	
	
	
	return 0;
}