# https://programmers.co.kr/learn/courses/30/lessons/43165
# 타겟넘버

from collections import deque


def solution(numbers, target):
    answer = 0

    def dfs(idx, sum):
        # print(idx,sum)
        if idx == len(numbers):
            if sum == target:
                nonlocal answer
                answer += 1
            return

        dfs(idx + 1, sum + numbers[idx])
        dfs(idx + 1, sum - numbers[idx])

    dfs(0, 0)

    return answer
