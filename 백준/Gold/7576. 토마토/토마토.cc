#include <iostream>
#include <vector>
#include <queue>

using namespace std;


int visited[1002][1002];
queue < pair<int, int>> q;

int day = 0;
int dx[] = { 0,0,1,-1 };
int dy[] = { 1,-1,0,0 };
int M, N;


void bfs() {
	bool flag = false;
	int count = q.size();
	int temp = 0;
	while (!q.empty()) {
		for (int i = 0; i < 4; i++)
		{
			int x, y;
			x = q.front().first + dx[i];
			y = q.front().second + dy[i];
			
			
			if (x < 0 || y < 0 || x >= N || y >= M)continue;
			if (visited[x][y] == 0) {
				visited[x][y] = 1;
				q.push({ x,y });
				temp++;
			}
		}
		q.pop();
		count--;
		if (count == 0) {
			count = temp;
			temp = 0;
			day++;
		}
	}
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			
			if (visited[i][j] == 0) {
				flag = true;
				break;
			}
		}
	}
	if (flag)cout << "-1";
	else
	cout << day-1;
}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	//전체 -1로 초기화
	for (int i = 0; i < 1002; ++i) {
		for (int j = 0; j < 1002; ++j) {
			visited[i][j] = -1;
		}
		
	}

	
	cin >> M >> N;

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			int input;
			cin >> input;
			if (input == 1)q.push({ i,j });
			visited[i][j] = input;
		}
	}
	
	bfs();

	
	return 0;
}
