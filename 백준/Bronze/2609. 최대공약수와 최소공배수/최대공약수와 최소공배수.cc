#include <iostream>
using namespace std;


int main() {
 
    int A, B;
    cin >> A >> B;
    int a, b, c;
    a = A;
    b = B;
    c = a % b;
    while (c != 0) {
        a = b;
        b = c;
        c = a % b;
    }
    cout << b << "\n" << (A * B) / b;


    return 0;
}
