# 백준 11047
# 동전 0

n, t = list(map(int, input().split(" ")))
coinList = []

for i in range(0, n):
    coinList.append(int(input()))

answer = 0
left = t
for coin in reversed(coinList):
    if t < coin:
        continue

    if left < coin:
        continue

    answer += left // coin
    left = left % coin
    #print(answer, left)

print(answer)