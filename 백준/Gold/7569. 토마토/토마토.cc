#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;


int visited[102][102][102];
queue < tuple<int,int, int>> q;

int day = 0;
int dz[] = { -1,1,0,0,0,0 };
int dx[] = { 0,0,0,0,1,-1 };
int dy[] = { 0,0,1,-1,0,0 };
int H,M, N;


void bfs() {
	bool flag = false;
	int count = q.size();
	int temp = 0;
	while (!q.empty()) {
		for (int i = 0; i < 6; i++)
		{
			int x, y,z;
			x = get<1>(q.front()) + dx[i];
			y = get<2>(q.front()) + dy[i];
			z = get<0>(q.front())+ dz[i];

			if (z < 0 || x < 0 || y < 0 || z >= H || x >= N || y >= M)continue;
			if (visited[z][x][y] == 0) {
				visited[z][x][y] = 1;
				q.push({ z,x,y });
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

	for (int k = 0; k < H; k++)
	{
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < M; j++)
			{

				if (visited[k][i][j] == 0) {
					flag = true;
					break;
				}
			}
		}
	}

	if (flag)cout << "-1";
	else
		cout << day - 1;
}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	//전체 -1로 초기화
	for (int k = 0; k < 102; k++)
	{
		for (int i = 0; i < 102; ++i) {
			for (int j = 0; j < 102; ++j) {
				visited[k][i][j] = -1;
			}

		}
	}


	cin >> M >> N>>H;
	for (int k = 0; k < H; k++)
	{
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < M; j++)
			{
				int input;
				cin >> input;
				if (input == 1)q.push({ k,i,j });
				visited[k][i][j] = input;
			}
		}
	}

	bfs();


	return 0;
}