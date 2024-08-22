#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

int arr[1001];
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N,M; //N은 계란갯수
    int total = 0;
    int max = 0;
    int price;
    int egg;
    int rePrice = 0;
    cin >> N>>M;
    for (int i = 0; i < M; i++)
    {
        cin >> arr[i];

    }
    for (int i = 0; i < M; i++)
    {   
        total = 0;
        egg = N;

        price = arr[i];
        
        
        for (int k = 0; k < M; k++)
        {
            
            if (arr[k] >= price) {
                total += price;
                egg--;

            }
            if (egg == 0)break;
        }
        if (max < total) {
            max = total;
            rePrice = price;
        }


    }
    cout << rePrice <<"\n" << max;
  
    return 0;
}