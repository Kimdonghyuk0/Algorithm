#include <iostream>
#include <cmath>
#include <string>

using namespace std;
long long zero_nine[10] = { 0 };
long long num9_999[11];
long long zero_num10[11];
long long original_size;
long long zero_count = 0;
long long resultZero;
bool flag = true;
string original_num;


void countZeroF(string number, int first,int secSize) {

	int size = number.length();
	long long result = pow(10, size - 1);
	int countZero = secSize - size;
	
	if (flag && countZero > 0) {
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

	}
	int size = number.length();
	original_size = number.length();
	int result = pow(10, size - 1);


	for (int i = 0; i < 10; i++)
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