#include <iostream>
#include <string>

using namespace std;



int main()
{
    int arr[101][101];
    for (int i = 0; i < 101; i++) {
        for (int j = 0; j < 101; j++) {
            arr[i][j] = -1;
        }
    }
    int N, M, side;
    string str;
    cin >> N >> M;
    if (N < M)side = N;
    else side = M;
   
    for (int i = 0; i < N; i++)
    {
        cin >> str;
        for (int j = 0; j < M; j++)
        {
            arr[i][j] = str[j]-'0';
        }
    }
  
    while (true)
    {
        bool flag = false;
        
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                if (arr[i + side - 1][j + side - 1] == -1)break;
                // 꼭지점 값이 같으면 종료
                if (arr[i][j] == arr[i][j + side - 1] && arr[i + side - 1][j] == arr[i + side - 1][j + side - 1] && arr[i][j] == arr[i + side - 1][j]) {
                    flag = true;
                    break;
                }
                
            }
            
            if (flag)break;
        }
      
       

        if (flag)break;
        side--;
    }

    cout << side * side;

    return 0;
}