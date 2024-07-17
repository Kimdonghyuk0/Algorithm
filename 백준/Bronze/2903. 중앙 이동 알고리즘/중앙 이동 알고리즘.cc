#include <iostream>

using namespace std;


int main()
{
	int count = 0;
	int point = 2;
	int n;
	cin>>n;
	while(true){
		
		count++;
		point = point*2-1;
		if(count==n)break;
		
	}
	cout<<point*point;
	
}