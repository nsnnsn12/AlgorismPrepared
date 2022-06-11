# https://www.acmicpc.net/problem/16917
# 양념 반 후라이드 반

import sys

a, b, c, x, y = list(map(int, input().split(" ")))
result = sys.maxsize

if a + b < c * 2:
    result = (a * x) + (b * y)
else:
    len = max(x, y)
    for i in range(len + 1):
        temp = ((c * 2) * i) + (a * max(0, x - i)) + (b * max(0, y - i))
        result = min(temp, result)

print(result)
