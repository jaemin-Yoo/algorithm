n = int(input())
result = []
for i in range(1, n+1):
    if i**2 > n:
        break
    
    if n % i == 0:
        result.append(i)
        result.append(n//i)
result.sort()
print(*result)