#include <iostream>
#include <cmath>
#include <string>

using namespace std;
long long zero_nine[10] = { 0 };
long long num9_999[11];
long long zero_num10[11];
long long original_size;
long long resultZero;
bool flag = true;
string original_num;


void countZeroF(string number, int first,int secSize) {

	int size = number.length();
	long long result = pow(10, size - 1);
	int countZero = secSize - size;
	//f2의 0 개수 구하기 방식과 같음
	if (flag && countZero > 0) { //0의 개수를 구할때도 0이 생략되기에 자릿수를 비교하고 f2함수와같이 동작함
		countZeroF(number, number[0] - '0', size);
		zero_nine[0] += countZero * (stoi(number) + 1);
		zero_nine[0] += resultZero;
		resultZero = 0;
		flag = false;
	}
	else if (flag) {
		zero_nine[0] += num9_999[size - 1] * (number[0] - '0');
		if (size > 1 && 0 < number[0] - '0')zero_nine[0] += result;
		else if (size == 1 && 0 <= number[0] - '0')zero_nine[0] += result;
	}
	if (size == 1) {

		return;
	}
	secSize = size - 1;
	long long num = stoi(number);
	num = num % result;
	countZeroF(to_string(num), number[0] - '0', secSize);



}

void f2(string number, int first, int secSize) {


	int size = number.length();
	long long result = pow(10, size - 1);
	int countZero = secSize - size;

	zero_nine[first] += stoi(number) + 1;

	if (original_size == 1)flag = false;

	for (int i = 1; i < 10; i++)
	{
		if(size>0)zero_nine[i] += num9_999[size - 1] * (number[0] - '0');

		if (size > 1 && i < number[0] - '0')zero_nine[i] += result;
		else if ( size == 1 && i <= number[0] - '0')zero_nine[i] += result;
	}
	
	if (flag && countZero > 0) { 
        //만약 숫자사이에 0이 끼게되면 num = num % result 으로 0이 사라지게됨
        //이를 해결하기위해 재귀호출직전 자릿수와 호출후 자릿수를 비교하여 0의 개수를 구함
        //구한 0의 개수에 number+1을 곱하고 number+1숫자에 0이 나온 수를 더해주면 됨
        // 이때 number+1숫자에 0이 나온 수는 0으로 시작하는 경우도 포함함 ex)0001,0002....0999
        //해당 if문 안에 들어올 시 0의 갯수는 즉각 확정됨. 따라서 flag를 fasle로하여 0의 개수를 고정함
		countZeroF(number, number[0] - '0',size);
		zero_nine[0] += countZero * (stoi(number) + 1);
		zero_nine[0] += resultZero;
		resultZero = 0;
		flag = false;
	}
	else if(flag) {
		zero_nine[0] += num9_999[size - 1] * (number[0] - '0');
		if (size > 1 && 0 < number[0] - '0')zero_nine[0] += result;
		else if (size == 1 && 0 <= number[0] - '0')zero_nine[0] += result;
	}


	if (size == 1) return;
	
	secSize = size - 1;
	int num = stoi(number);
	num = num % result;
	f2(to_string(num), number[0] - '0', secSize);



}

void f1(string number) {
	for (int i = 2; i < 11; i++)
	{
		long long result = pow(10, i - 1);
		num9_999[i] = num9_999[i - 1] * 10 + result;
		if (i > 2)zero_num10[i] = num9_999[i - 1] * 9 + zero_num10[i - 1];

	}//0부터9999..까지 더했을때 0의 개수와 그 외 숫자의 개수는 위같은 식으로 구할 수 있음
	int size = number.length();
	original_size = number.length();
	int result = pow(10, size - 1);


	for (int i = 0; i < 10; i++)
     //예를들어 52345라는 숫자가 있으면 아래식을 이용해서 1부터 49999까지의 모든 숫자 개수를 구할 수 있음
     // 그럼 50000부터 52345까지의 숫자 개수를 구하고 더하면됨 이렇게 재귀함수를 돎
  
	{

		if (i == 0) {
			zero_nine[0] += zero_num10[size - 1] + num9_999[size - 1] * ((number[0] - '0') - 1);
		}
		else zero_nine[i] += num9_999[size - 1] * (number[0] - '0');
		if (i != 0 && i < number[0] - '0')zero_nine[i] += result;


	}
	int secSize = size - 1;
	int num = stoi(number);
	num = num % result;
	f2(to_string(num), number[0] - '0', secSize);
}


int main() {
//ex)7019입력시
//1부터 6999까지의 모든 숫자 개수는 식으로 바로 구할 수 있음
//0,1,9로 만들수있는 19보다 작은 모든 경우의 숫자 개수를 1부터 6999까지의 모든 숫자 개수에 더하면됨
//숫자 길이가 1이 될때까지 재귀함수를 돌며 답을 도출
	string number;
	resultZero = 0;
	cin >> number;

	original_num = number;
	zero_num10[0] = 0;
	zero_num10[1] = 0;
	zero_num10[2] = 9;
	num9_999[1] = 1;

	f1(number);

	for (int i = 0; i < 10; i++)
	{
		cout << zero_nine[i] << " ";
	}


	return 0;

}
