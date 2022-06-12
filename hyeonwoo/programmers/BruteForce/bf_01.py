# https://programmers.co.kr/learn/courses/30/lessons/42840?language=python3
# 모의고사


def solution(answers):
    answer = []

    user1 = [1, 2, 3, 4, 5]
    user2 = [2, 1, 2, 3, 2, 4, 2, 5]
    user3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]

    resultList = [0, 0, 0]

    for i in range(len(answers)):
        if user1[i % len(user1)] == answers[i]:
            resultList[0] += 1

        if user2[i % len(user2)] == answers[i]:
            resultList[1] += 1

        if user3[i % len(user3)] == answers[i]:
            resultList[2] += 1

    maxValue = max(resultList)

    for i in range(len(resultList)):
        if maxValue == resultList[i]:
            answer.append(i + 1)

    return answer
