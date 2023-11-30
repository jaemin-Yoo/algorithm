import sys
input = sys.stdin.readline

def solve():
    for i in range(8):
        for j in range(i+1, 9):
            a = dwarf[i]
            b = dwarf[j]
            if diff == a + b:
                dwarf.remove(a)
                dwarf.remove(b)
                return 0

dwarf = []
for _ in range(9):
    dwarf.append(int(input()))

dwarf.sort()
diff = sum(dwarf) - 100

solve()
for i in dwarf:
    print(i)