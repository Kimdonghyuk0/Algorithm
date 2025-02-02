def solve():
    import sys
    input = sys.stdin.readline

    n = int(input().strip())
    counts = [0] * 10

    # 자리수별로 각 숫자가 몇 번 등장하는지 계산
    # factor: 현재 자릿수 (1, 10, 100, …)
    for d in range(10):
        count = 0
        factor = 1
        while factor <= n:
            # higher: 현재 자리수보다 높은 자리의 숫자들
            # curr: 현재 자리의 숫자
            # lower: 현재 자리수보다 낮은 자리의 숫자들
            higher = n // (factor * 10)
            curr = (n // factor) % 10
            lower = n - (n // factor) * factor

            if d == 0:
                # 0의 경우에는 선행하는 0은 세지 않으므로 특별히 처리한다.
                if higher == 0:
                    # 더 이상 의미있는 자릿수가 없으므로 종료
                    break
                if curr == 0:
                    count += (higher - 1) * factor + lower + 1
                else:
                    count += higher * factor
            else:
                if curr < d:
                    count += higher * factor
                elif curr == d:
                    count += higher * factor + lower + 1
                else:
                    count += (higher + 1) * factor

            factor *= 10
        counts[d] = count

    sys.stdout.write(" ".join(map(str, counts)))


if __name__ == '__main__':
    solve()
