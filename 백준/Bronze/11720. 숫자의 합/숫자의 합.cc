#include <iostream>

#include <string>

using namespace std;

int main()

{

    int N;

    int sum = 0;

    cin >> N;

    

    string numbers;

    cin >> numbers;

    

    for (int i = 0; i < N; i++) {

        sum += numbers[i] - '0'; // 각 문자를 숫자로 변환하여 더하기

    }

    cout << sum << endl;

    return 0;

}