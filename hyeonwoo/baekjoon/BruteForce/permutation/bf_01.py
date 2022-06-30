# https://www.acmicpc.net/problem/2529
# 부등호


def check(x, y, op):
    if op == "<":
        if x > y:
            return False
    if op == ">":
        if x < y:
            return False
    return True


def recur(idx, num):
    if idx == k + 1:
        answers.append(num)
        return

    for i in range(10):
        if visited[i]:
            continue

        if idx == 0 or check(num[idx - 1], str(i), ops[idx - 1]):
            visited[i] = True
            recur(idx + 1, num + str(i))
            visited[i] = False


k = int(input())
ops = input().split()

answers = []
visited = [False] * 10  # 해당 숫자를 사용했는지 안 했는지 체크

recur(0, "")

answers.sort()
print(answers[-1])
print(answers[0])
