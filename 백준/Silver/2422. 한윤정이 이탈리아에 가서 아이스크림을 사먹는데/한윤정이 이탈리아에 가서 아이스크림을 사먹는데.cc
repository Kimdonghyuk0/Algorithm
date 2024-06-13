#include <iostream>
using namespace std;

const int MAX_N = 201; 

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    cin >> N >> M;

    bool isBad[MAX_N][MAX_N] = {false}; // 금지된 조합을 저장할 2차원 배열 초기화
    int a, b;
    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        isBad[a][b] = isBad[b][a] = true; // 양방향으로 금지된 조합을 설정
    }

    int count = 0; // 금지된 조합을 포함하지 않는 아이스크림 조합 수

    
    for (int i = 1; i <= N - 2; i++) {
        for (int j = i + 1; j <= N - 1; j++) {
            for (int k = j + 1; k <= N; k++) {
                if (!isBad[i][j] && !isBad[i][k] && !isBad[j][k]) {
                    count++; // 세 아이스크림 모두 금지된 조합을 포함하지 않으면 카운트
                }
            }
        }
    }

    cout << count << endl;

    return 0;
}