#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

int bj() {
    int n;
    string cate,name;
    int cateN;
    long long count = 1;
    unordered_map<string, vector<string>> m;
    cin >> n;
    
    for (int i = 0; i < n; i++)
    {
        cin >> name >> cate;
        m[cate].push_back(name);
    }
    cateN = m.size();
    for (auto iter = m.begin(); iter != m.end(); iter++)
    {
        count *= iter->second.size() + 1;
    }

    return count-1;   
}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int T;
    cin >> T;
    while (T--) {
        long long result = bj();
        cout << result << "\n";
    }
  
    return 0;
}