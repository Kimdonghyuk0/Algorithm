#include <iostream>

using namespace std;

int arr[100][2];

int main()

{	int N;	

int total;

int sum=0;

cin>>total>>N;

for(int i = 0; i<N; i++){

	cin>>arr[i][0]>>arr[i][1];

	sum+=arr[i][0]*arr[i][1];

	

}

if(total==sum)

cout<<"Yes";

else cout<<"No";

	

}