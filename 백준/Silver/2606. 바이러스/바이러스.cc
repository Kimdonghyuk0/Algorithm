#include <iostream>
#include <vector>

using namespace std;

bool visited[101]; //true인 갯수가 정답
vector<int> graph[101];

void dfs(int x) {
	visited[x] = true;
	for (int i = 0; i < graph[x].size(); i++)
	{
		int y = graph[x][i];
		if (!visited[y]) {
			dfs(y);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int N, M;
	int count = 0;
	cin >> N >> M;
	for (int i = 0; i < M; i++)
	{
		int x, y;
		cin >> x >> y;
		graph[x].push_back(y);
		graph[y].push_back(x);
	}
	dfs(1);
	for (int i = 0; i < 101; i++)
	{
		if (visited[i])count++;
	}
	cout << count-1;
	
	return 0;
}
