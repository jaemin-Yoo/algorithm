def solution(s):
    answer = len(s)
    
    for l in range(1, len(s)//2+1):
        
        arr = []
        for i in range(0, len(s), l):
            arr.append(s[i:i+l])
        
        v = arr[0]
        state = 1
        cnt = len(s)
        for i in range(1, len(arr)):
            if v == arr[i]:
                state += 1
                cnt -= l
            else:
                if state > 1:
                    cnt += len(str(state))
                
                v = arr[i]
                state = 1
        
        if state > 1:
            cnt += len(str(state))
        
        if answer > cnt:
            answer = cnt
    
    return answer