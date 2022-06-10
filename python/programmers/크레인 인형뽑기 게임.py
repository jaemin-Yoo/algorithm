def solution(board, moves):
    answer = 0
    
    arr = []
    for p in moves:
        for row in board:
            if row[p-1] != 0:
                if len(arr) != 0 and row[p-1] == arr[-1]:
                    arr.pop()
                    answer += 2
                else:
                    arr.append(row[p-1])
                
                row[p-1] = 0
                break
    
    return answer