# 백준 11399
# ATM

n = int(input())
list = list(map(int, input().split(" ")))

sum = 0
totalSum = 0
for num in sorted(list):
    sum += num
    totalSum += sum
    
print(totalSum)