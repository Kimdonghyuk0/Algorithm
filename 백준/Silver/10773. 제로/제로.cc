#include <iostream>
#include <vector>

using namespace std;


int main() {
    int N;
    int temp;
    int sum = 0;
    cin >> N;
    vector<int> v;
    for (int i = 0; i < N; i++) {
        cin >> temp;
        if (temp != 0)v.push_back(temp);
        else v.pop_back();
    }
    for (int i = 0; i < v.size(); i++) {
        sum += v[i];
    }
    cout << sum;
 
    return 0;
}
