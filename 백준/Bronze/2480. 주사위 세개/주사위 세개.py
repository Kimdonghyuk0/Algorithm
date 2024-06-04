def calculate_prize(dice):
    counts = {}
    for number in dice:
        if number in counts:
            counts[number] += 1
        else:
            counts[number] = 1

    if 3 in counts.values():  # 같은 눈이 3개인 경우
        for num, count in counts.items():
            if count == 3:
                return 10000 + num * 1000
    elif 2 in counts.values():  # 같은 눈이 2개인 경우
        for num, count in counts.items():
            if count == 2:
                return 1000 + num * 100
    else:  # 모든 눈이 다른 경우
        return max(dice) * 100

# 사용자 입력을 받습니다.
input_dice = input()
dice = list(map(int, input_dice.split()))

# 상금 계산
prize = calculate_prize(dice)
print(prize)
