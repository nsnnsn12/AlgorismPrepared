# https://www.acmicpc.net/problem/16922
# 로마 숫자 만들기

### 첫 시도 BackTracking 시간초과 : 4 ^ 20
# def bt(idx, max, sum, numList):
#     if idx >= max:
#         resultSet.add(sum)
#         return

#     for i in range(len(numList)):
#         bt(idx + 1, max, sum + numList[i], numList)


# n = int(input())
# numList = [1, 5, 10, 50]
# resultSet = set()

# #bt(0, n, 0, numList)

# print(len(resultSet))

### 2차시도 3중 For문 : 20 ^ 3

n = int(input())
numList = [1, 5, 10, 50]
resultSet = set()

for i in range(n + 1):  # I를 i개 선택
    for j in range(n - i + 1):  # V를 j개 선택
        for k in range(n - i - j + 1):  # X를 k개 선택
            l = n - i - j - k  # L을 l개 선택
            sum = (1 * i) + (5 * j) + (10 * k) + (50 * l)
            resultSet.add(sum)

print(len(resultSet))

a, b, c = 1, 2, 3
print([a, b, c])
