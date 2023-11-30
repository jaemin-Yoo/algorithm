decode = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
          'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
          '0','1','2','3','4','5','6','7','8','9','+','/'
         ]

t = int(input())
for idx in range(1, t+1):
    s = input()
    
    bn = ""
    for i in s:
        bn += format(decode.index(i), 'b').zfill(6)
        
    result = ""
    for i in range(0, len(bn), 8):
        n = int(bn[i:i+8], 2)
        result += chr(n)
    
    print("#{} {}".format(idx, result))