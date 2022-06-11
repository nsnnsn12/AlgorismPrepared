# https://www.acmicpc.net/problem/16968
# 차량번호판 1

str = input()
result = 1
lastType = ""

for s in str:
    if s == "c":
        if lastType == "c":
            result *= 25
        else:
            result *= 26
        lastType = "c"

    if s == "d":
        if lastType == "d":
            result *= 9
        else:
            result *= 10
        lastType = "d"

print(result)
