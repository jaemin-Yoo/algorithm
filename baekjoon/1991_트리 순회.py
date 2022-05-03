import sys
input = sys.stdin.readline

def preT(parent):
    print(parent, end="")
    for node in graph[parent]:
        if node != ".":
            preT(node)
        
def inT(parent):
    lc = graph[parent][0]
    rc = graph[parent][1]
    
    if lc != '.':
        inT(lc)
    print(parent, end="")
    if rc != '.':
        inT(rc)

def postT(parent):
    for node in graph[parent]:
        if node != ".":
            postT(node)
    print(parent, end="")

n = int(input())
graph = {}
for _ in range(n):
    p, lc, rc = input().split()
    graph[p] = [lc, rc]

preT("A")
print()
inT("A")
print()
postT("A")