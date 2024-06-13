#include<iostream>

using namespace std;

int arr[100];

int main()

{

	int count = 0;	int n;

	int target;

	

	cin>>n;

	for(int i=0; i<n; i++){

	cin>>arr[i];	

	}

	cin>>target;

	for(int i = 0; i<n; i++){

		if(arr[i]==target)count++;

		

	}

	cout<<count;

}