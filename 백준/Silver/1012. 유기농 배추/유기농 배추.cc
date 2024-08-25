#include <iostream>
#include <vector>

using namespace std;

bool visited[2501][2501]; 

vector<pair<int, int>> xy;
vector<pair<int,int>> graph[2501][2501];

void dfs(int x,int y) {
	visited[x][y] = false;
	for (int i = 0; i < graph[x][y].size(); i++)
	{
		int x1 = graph[x][y][i].first;
		int y1 = graph[x][y][i].second;
		if (visited[x1][y1]) {
			dfs(x1, y1);
		}
	}
	
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int M, N, K,T;
	cin >> T;
	while (T--) {
		
		cin >> M >> N >> K;
		int count = 0;
		for (int i = 0; i < K; i++)
		{
			int x, y;
			cin >> x >> y;
			xy.push_back({ x,y });
			graph[x][y].push_back({ x - 1, y });
			graph[x][y].push_back({ x + 1, y });
			graph[x][y].push_back({ x , y + 1 });
			graph[x][y].push_back({ x, y - 1 });
			visited[x][y] = true;
		}
		for (int i = 0; i < xy.size(); i++)
		{
			if (visited[xy[i].first][xy[i].second]) {
				count++;
				dfs(xy[i].first, xy[i].second);
			}
		}

		cout << count<<"\n";

	}
	
	return 0;
}
