#include <iostream>


using namespace std;



int main() {
    int n;
    cin >> n;
   
    int bigCount = 0;
    int smallCount = 0;
    int big = n / 5;
    

    while (true) {
        int temp = n - (big * 5);
        if (temp % 3 == 0) {
            bigCount = big;
            smallCount = temp / 3;
            break;
        }
        big--;
         if (big == -1) {
            bigCount = 0;
            smallCount = -1;
            break;
        }
    }
    cout << bigCount + smallCount;

 
    return 0;
}
