#include <iostream>

using namespace std;


int main() {
    int N;
    cin >> N;
    int start = 1;
    int end = 1;
    int count = 0;
   
    while (true) {
        count++;
        if (start <= N && N <= end)break;
       
        start = end + 1;
        end += (6 * count);
    }

    cout << count;
 
    return 0;
}
