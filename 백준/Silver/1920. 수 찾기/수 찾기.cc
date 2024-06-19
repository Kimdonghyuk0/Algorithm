#include <iostream>
#include <unordered_map>
using namespace std;




int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    unordered_map<int, int> map;

    int n, m;
    int num = 0;
    int k;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> k;
        map.insert(make_pair(k, k));
    }

    cin >> m;
    for (int i = 0; i < m; i++) {
        cin >> num;
        if (map.find(num) != map.end())cout << "1" << "\n";
        else  cout << "0" << "\n";
       
    }


    return 0;
}
