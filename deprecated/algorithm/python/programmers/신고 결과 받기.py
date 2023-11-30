def solution(id_list, report, k):
    answer = [0 for _ in range(len(id_list))]
    reports = {}
    id_report = {}
    
    for i in id_list:
        reports[i] = 0
        id_report[i] = []
    
    for row in set(report):
        a, b = row.split()
        reports[b] += 1
        id_report[b].append(a)
        
    for i in id_list:
        if reports[i] >= k:
            for j in id_report[i]:
                answer[id_list.index(j)] += 1
            
    return answer