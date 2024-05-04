#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main() {
    int N = 0;
    cin >> N;

    string** arr = new string * [51];

    for (int i = 0; i < 51; ++i) {
        arr[i] = new string[N];
    }

    int wordCounts[51] = { 0 };

    for (int i = 0; i < N; i++) {
        string word;
        cin >> word;

        int j;
        for (j = 0; !arr[word.size()][j].empty(); j++);
        arr[word.size()][j] = word;
        wordCounts[word.size()]++;
    }

    string recent = "";
    for (int i = 0; i < 51; i++) {
        sort(arr[i], arr[i] + wordCounts[i]);
        for (int j = 0; j < wordCounts[i]; j++) {
            if (recent != arr[i][j]) {
                cout << arr[i][j] << endl;
            }
            recent = arr[i][j];
        }
    }

    for (int i = 0; i < 51; ++i) {
        delete[] arr[i];
    }
    delete[] arr;

    return 0;
}
