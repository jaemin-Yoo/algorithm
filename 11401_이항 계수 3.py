import sys
input = sys.stdin.readline

def power(a, b):
    if b == 0:
        return 1
    if b % 2:
        return (power(a, b // 2) ** 2 * a) % p
    else:
        return (power(a, b // 2) ** 2) % p

p = 1000000007
n, k = map(int, input().split())

fact = [1 for _ in range(n+1)]
for i in range(2, n+1):
    fact[i] = fact[i-1] * i % p

child = fact[n]
parent = (fact[n-k] * fact[k]) % p
print((child % p) * (power(parent, p - 2) % p) % p)