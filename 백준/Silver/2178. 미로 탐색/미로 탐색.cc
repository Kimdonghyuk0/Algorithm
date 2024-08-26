#include <iostream>
#include<queue>

using namespace std;

int N, M;
int dx[] = {1,-1,0,0};
int dy[] = {0,0,1,-1};
int visited[101][101];

queue<pair<int, int>> q;


void bfs(int y, int x) {
	int yy, xx;
	q.push({ y,x });
	while (!q.empty()) {
		y = q.front().first;
		x = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++)
		{
			yy = y + dy[i];//다음에 이동할 곳
			xx = x + dx[i];
			if (xx < 0 || yy < 0 || xx >= M || yy >= N )continue;
			if (visited[yy][xx]) { // 1이상인경우 탐색
				
				if (visited[yy][xx] == 1) {
					q.push({ yy,xx });
					visited[yy][xx] += visited[y][x];
				}
				else if (visited[y][x] + 1 < visited[yy][xx]) {
					q.push({ yy,xx });
					visited[yy][xx] = visited[y][x]+1;
				}
			}
		}

	}
	
	
}	

string str[101];

int main(){


	cin >> N >> M;
	for (int i = 0; i < N; i++)
	{
		cin >> str[i];
	}
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			visited[i][j] = str[i][j] - '0';
	
		}
	}

	bfs(0, 0);

	cout << visited[N - 1][M - 1];

	return 0;
}
