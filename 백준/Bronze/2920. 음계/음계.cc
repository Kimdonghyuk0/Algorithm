#include <iostream>

using namespace std;

int arr[9];

int main()
{
	bool flag = false;
	
	
	for(int i = 0; i<8; i++){
		cin>>arr[i];	
	}
	
		for(int i = 0; i<8; i++){
		if(i+1==arr[i]){
			flag = true;
		}
		else{
			flag = false;
			break;
		}
	}
	if(flag){
		cout<<"ascending"<<endl;
		return 0;
	}
	
		
		for(int i = 0; i<8; i++){
		if((8-i)==arr[i]){
			flag = true;
		}
		else{
			flag = false;
			break;
		}
	}
	if(flag){
		cout<<"descending"<<endl;
		return 0;
	}
	cout<<"mixed";
	
	
	
}