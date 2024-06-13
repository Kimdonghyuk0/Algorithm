#include <iostream>

using namespace std;

int arr[100];

int main()

{

	int n,m;	cin>>n>>m;

	int i,j,k;

	for(int a = 0; a<m; a++){

		cin>>i>>j>>k;

		for(int b = i; b<=j; b++){

			arr[b]=k;

		}

		

		

	}

	

	for(int a = 1; a<=n; a++){

		cout<<arr[a]<<" ";

		

		

	}

	

}