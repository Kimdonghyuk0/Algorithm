#include <iostream>
#include<vector>

using namespace std;

int main() {
	int N;
	int K;
	int pointer = 0;

	cin >> N >> K;
	
	int* arr = new int[N];
	
	
	vector <int> v;
	for (int i = 0; i < N; i++) {
		v.push_back(i+1);
	}

	int n = N;

	for (int i = 0; i < N; i++) {
		
		pointer = (pointer + (K - 1)) % n;
		arr[i] = v[pointer];
		v.erase(v.begin()+pointer);
		n--;
	}	
	

	for (int i = 0; i < N; i++) {
		if(i == 0)cout << "<";
		if (i == N - 1)cout << arr[i]<<">";
		else cout << arr[i] << ", ";
	}

	
	delete[] arr;
	
	return 0;
}