def solution(lottos, win_nums):
    rank = [6, 6, 5, 4, 3, 2, 1]
    
    zero_cnt = lottos.count(0)
    cnt = 0
    for i in win_nums:
        if i in lottos:
            cnt += 1
    
    answer = [rank[zero_cnt + cnt], rank[cnt]]
    
    return answer