#include <iostream>
#include<queue>

using namespace std;

int dx[] = {1,-1,0,0,1,-1,-1,1};
int dy[] = {0,0,1,-1,1,-1,1,-1};
int w, h;
bool visited[51][51];
queue<pair<int, int>> q;
vector<pair<int, int>> land;

void bfs(int y, int x) {
	visited[y][x] = false;
	q.push({ y,x });
	while (!q.empty()) {
		int y1,x1;
		int y2, x2;
		y2 = q.front().first;
		x2 = q.front().second;
		q.pop();
		for (int i = 0; i < 8; i++)
		{
			y1 =  y2 + dy[i]; 
			x1 =  x2 + dx[i];
			if (x1 < 0 || y1 < 0 || y1 >= h || x1 >= w)continue;
			if (visited[y1][x1]) { q.push({ y1, x1 });visited[y1][x1] = false; }
		}
	}
}

int main(){

	

	while (true) {
		//초기화
		for (int i = 0; i < 51; i++)
		{
			for (int j = 0; j < 51; j++)
			{
				visited[i][j] = false;
			}
		}
		int count = 0;

		cin >> w >> h;
		if (w == 0 && h == 0)break;
		for (int i = 0; i < h; i++)
		{
			for (int j = 0; j < w; j++)
			{
				int input;
				cin >> input;
				
				if (input == 1) {
					land.push_back({ i,j });
					visited[i][j] = true;
				}
				else visited[i][j] = false;
			}
		}
		for (int i = 0; i < land.size(); i++)
		{
			if (visited[land[i].first][land[i].second]) {
				count++;
				bfs(land[i].first, land[i].second);
			}
		}

		cout << count<<"\n";
	}
	return 0;
}
