#include <iostream>
#include <limits>

using namespace std;



int main() {
	
	
	int num;
	int i = 0;
    while (true) {  // 무한 루프 시작
        if (cin >> num) {
            break;  // 입력이 성공하면 루프에서 바로 탈출
        }
        cin.clear(); // cin의 에러 상태 클리어
        cin.ignore(numeric_limits<streamsize>::max(), '\n'); // 입력 버퍼 비우기
    
        i++;  // 실패 횟수 증가
    }
    num += (3 - i);
    if (num % 3 == 0 && num % 5 == 0)cout << "FizzBuzz";
    else if (num % 3 == 0 && num % 5 != 0)cout << "Fizz";
    else if (num % 3 != 0 && num % 5 == 0)cout << "Buzz";
    else if (num % 3 != 0 && num % 5 != 0)cout << num;





 return 0;
}
