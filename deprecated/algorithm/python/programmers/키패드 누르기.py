keypad = ["?", "L", "?", "R", "L", "?", "R", "L", "?", "R"]
pos = [(3, 1), (0, 0), (0, 1), (0, 2), (1, 0), (1, 1), (1, 2), (2, 0), (2, 1), (2, 2)]

def solution(numbers, hand):
    answer = ''
    
    l_pos = (3, 0)
    r_pos = (3, 2)
    for i in numbers:
        if keypad[i] == "?":
            l_v = abs(pos[i][0] - l_pos[0]) + abs(pos[i][1] - l_pos[1])
            r_v = abs(pos[i][0] - r_pos[0]) + abs(pos[i][1] - r_pos[1])
            if l_v > r_v:
                r_pos = pos[i]
                answer += "R"
            elif l_v < r_v:
                l_pos = pos[i]
                answer += "L"
            else:
                if hand == "right":
                    r_pos = pos[i]
                    answer += "R"
                else:
                    l_pos = pos[i]
                    answer += "L"
                
        else:
            if keypad[i] == "L":
                l_pos = pos[i]
            else:
                r_pos = pos[i]
                
            answer += keypad[i]
        
    return answer