t = int(input())
for idx in range(1, t+1):
    s = input()
    vowel = ["a", "e", "i", "o", "u"]
    result = ""
    for i in s:
        if i not in vowel:
            result += i
    
    print("#{} {}".format(idx, result))