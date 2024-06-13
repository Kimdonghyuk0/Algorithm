#include <iostream>

using namespace std;

int arr[46];

int main()

{

	int n;	int s1,s2;

	s1 = 0;

	s2 = 1;

	cin>>n;

	arr[1] = s1;

	arr[2] =s2;

	for(int i = 3; i <= n+1; i++){

		arr[i] = s1 + s2;

	    int temp;

	    temp = s2;

		s2 +=s1;	

		s1 = temp;

	}

	cout<<arr[n+1];

}