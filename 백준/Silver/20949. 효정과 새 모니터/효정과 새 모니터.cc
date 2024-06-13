#include <iostream>

using namespace std;

int main(){
	int N,a,b,temp;
	int max=0;
	int key;
	int arr[1000][2]={{0}};
	cin >> N;
	for(int i = 0; i<N; i++){
		cin >>a >>b;
		temp = (a+b)*(a+b)-2*a*b;
		arr[i][0]=temp;
		arr[i][1]=i+1;
	}
	
	
   for(int i = 0; i<N; i++){
   	max=0;
   	key=0;
   	for(int j = 0; j<N; j++){
   		if(arr[j][0]>max){
   			max=arr[j][0];
   			key=arr[j][1];
   			
   		}
   		
   	}
   	if(key>0){
   	arr[key-1][0]=0;
   	cout<<key<<"\n";
   }
   }
	
	
	
}