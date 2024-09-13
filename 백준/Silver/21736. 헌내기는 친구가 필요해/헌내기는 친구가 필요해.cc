#include <iostream>
#include <queue>

using namespace std;

int N, M;
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1, 0,0 };
// 0 이면 미방문 1이면방문 2이면 사람
int visited[602][602]; 
queue <pair<int, int>> q;

//O는 빈 공간, X는 벽, I는 도연이, P는 사람이다.I가 한 번만 주어짐이 보장된다.
int bfs(int y,int x) {
	int count = 0;
	q.push({ y,x });
	visited[y][x] = 1;
	while (!q.empty()) {
		
		y = q.front().first;
		x = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++)
		{
			int y1 = y+dy[i];
			int x1 = x+dx[i];
			if (y1 < 0 || x1 < 0 || y1 >= N || x1 >= M) {
				continue;
			}
			if (visited[y1][x1] == 2) {
				count++;
				q.push({ y1,x1 });
				visited[y1][x1] = 1;
			}
			else if (visited[y1][x1] == 0) {
				
				q.push({ y1,x1 });
				visited[y1][x1] = 1;
			}

		}
	}

	return count;
}

int main() {
	
	int startX, startY;
	
	cin >> N >> M;
	for (int i = 0; i < N; i++)
	{
		string input;
		cin >> input;
		for (int k = 0; k < M; k++)
		{
			if (input[k] == 'X')visited[i][k] = 1;
			else if (input[k] == 'P')visited[i][k] = 2;
			else if (input[k] == 'I') {
				startX = k;
				startY = i;
				
			}
		}
	}

	int ans = bfs(startY, startX);
	if (ans > 0)cout << ans;
	else cout << "TT";
	

	return 0;
}