#include <iostream>
#include <algorithm>

using namespace std;

int arr1[51];
int arr2[51];

bool com(int a, int b){
	return a>b;
}
int main()
{
	int n;
	int sum = 0;
	cin>>n;
	for(int i = 0; i < n; i++){
		cin>>arr1[i];
	}
	sort(arr1,arr1+n);
		for(int i = 0; i < n; i++){
		cin>>arr2[i];
	}
	sort(arr2,arr2+n,com);
		for(int i = 0; i < n; i++){
		sum+=arr1[i]*arr2[i];
	}
	
	cout<<sum;
	
}