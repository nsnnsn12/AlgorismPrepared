# https://programmers.co.kr/learn/courses/30/lessons/43162?language=python3
# 네트워크


def solution(n, computers):
    answer = 0

    visited = [False for _ in range(n)]

    def dfs(st):
        visited[st] = True

        for i in range(len(computers[st])):
            if computers[st][i] == 1 and visited[i] == False:
                dfs(i)

    for i in range(n):
        if visited[i] == False:
            print(i, answer)
            dfs(i)
            print(visited)
            answer += 1

    return answer
