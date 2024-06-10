#include <iostream>
using namespace std;

int main(){
    int arr[9];
    int max = -1;
    int num;
    for(int i = 0; i<9; i++){
        cin>>arr[i];
        if(max<arr[i]){max = arr[i];
            num = i+1;}
        
    }
    cout<<max<<"\n"<<num;
}