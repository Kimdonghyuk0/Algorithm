#include <iostream>

using namespace std;


int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    long long T;
    
    long long num;
    

    cin >> T;
    while (T--) {
    
        long long count5 = 0;
        long long div = 5;
        cin >> num;
        
            while (div <= num) {
                count5 += num / div;
                div *= 5;
            }
            
        cout << count5<<'\n';
        
    }
    
    
    
    return 0;
}