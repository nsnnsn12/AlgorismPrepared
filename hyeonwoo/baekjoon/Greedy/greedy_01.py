# 백준 2839
# 설탕 배달

n = int(input())

answer = float('inf')

cnt3 = 0
cnt5 = 0

tempAnswer = float('inf')
for i in range(0, int(n / 5) + 1):
    left = n - (5*i)
    if left % 3 != 0:
        tempAnswer = -1
    else:
        tempAnswer = i + int(left / 3)
        answer = min(tempAnswer, answer)
    #print("tempAnswer : {0}".format(tempAnswer))
    

if answer == float('inf'):
    print("-1")
else:
    print("{0}".format(answer))