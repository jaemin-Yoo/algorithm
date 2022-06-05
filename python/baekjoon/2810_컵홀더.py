import sys
input = sys.stdin.readline

n = int(input())
s = input().rstrip()
s_count = s.count("S")
l_count = s.count("LL")
print(min(len(s), s_count+l_count+1))