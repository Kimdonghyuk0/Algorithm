#include<iostream>

#include<cstdlib>

using namespace std;

int arr[50];

int main()

{

	int n;	cin>>n;

	for(int i = 0; i < n; i++){

	cin >>arr[i] ;

	}

	

int target = arr[0];

	while(true){

	int k =1;	

	int max =arr[1];

	for(int i = 1; i<n; i++){

		if(max<arr[i]){

			max = arr[i];

			k = i;

		}

		}

	

	if(arr[0]<=max){

	arr[k]--;

	arr[0]++;

	}

	else break;

	}

	

	cout<<arr[0]-target;

	

	return 0;

	

}