#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

long long start[100001];
long long grow[100001];

bool compare(const pair<long long, long long>& a, const pair<long long, long long>& b) {
    if (a.first == b.first) {
        return start[a.second] > start[b.second];
    } else {
        return a.first < b.first;
    }
}

int main() {
    vector<pair<long long, long long>> v; //(grow, index)
    long long n;
    long long day;
    long long ans = 0;
    cin >> n;
    day = n;

    for (long long i = 0; i < n; i++) {
        cin >> start[i];
    }

    for (long long i = 0; i < n; i++) {
        cin >> grow[i];
    }
    for (long long i = 0; i < n; i++) {
        v.push_back({grow[i], i});
    }
    sort(v.begin(), v.end(), compare);
    for (long long i = 0; i < n; i++) {
        ans += i * v[i].first + start[v[i].second];
    }

    cout << ans;
    return 0;
}
