num = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]

def solution(s):
    answer = ""
    temp = ""
    for i in s:
        if "0"<=i<="9":
            answer += i
        else:
            temp += i
        
        if  temp in num:
            idx = num.index(temp)
            answer += str(idx)
            temp = ""
            
    return int(answer)