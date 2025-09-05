# 2252 줄 세우기
from collections import deque
import sys

input = sys.stdin.readline

if __name__ == '__main__':
    N, M = map(int, input().split())
    graph = [[] for _ in range(N + 1)]  # 단방향 그래프
    indegree = [0] * (N + 1)  # 진입 차수 배열

    for _ in range(M):
        A, B = map(int, input().split())
        graph[A].append(B)  # A -> B
        indegree[B] += 1

    queue = deque()
    result = []
    # queue의 초기값(시작점): 진입 차수가 0인 노드
    for i in range(1, N + 1):
        if indegree[i] == 0:
            queue.append(i)

    while queue:
        node = queue.popleft()
        result.append(node)  # 결과값 저장

        for next in graph[node]:
            indegree[next] -= 1
            if indegree[next] == 0:  # 진입 차수가 0이 되면
                queue.append(next)  # 이제 너 차례
    
    print(" ".join(map(str, result)))