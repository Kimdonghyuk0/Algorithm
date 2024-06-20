#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int arr[100001];



int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
   
    vector<string> v;
    stack<int> s;
    int n;
    
    int num = 1;
    int count = 0;
    int k = 0;
    // max보다 작은애가 오름차순이면 안된다.
    // 단 오름차순에서 제일 큰 값이 max보다 작아야함


    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
   
    while (true) {
       
    
        s.push(num);
        v.push_back("+");
        while (true) {
            if (s.empty())break;
            if (arr[k] == s.top()) {
                s.pop();
                k++;
                v.push_back("-");
                count++;
               
            }
            else break;
        }
        
        if (count == n)break;
        if (num > n) {
            cout << "NO";
            return 0;
        }
        num++;
      
    }
    for (int i = 0; i < v.size(); i++)
    {
        cout << v[i]<<"\n";
    }
    return 0;
}
