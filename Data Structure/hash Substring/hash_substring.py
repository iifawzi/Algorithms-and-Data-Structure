# python3
import random
def read_input():
    return (input().rstrip(), input().rstrip())

def print_occurrences(output):
    for i in output:
        print (i,end =" ")

def PolyHash(S, p, x):
    hash = 0
    for char in reversed(S):
        hash = ((hash * x + ord(char)) % p + p) %p
    return hash

def PreComputeHashes(T, lp, p, x):
    lt = len(T)
    H, S = [None] * (lt - lp + 1), T[lt - lp:lt]
    H[lt - lp], y = PolyHash(S, p, x), 1
    for i in range(lp):
        y = (y * x) % p
    for i in range(lt - lp - 1, -1, -1):
        H[i] = (x * H[i + 1] + ord(T[i]) - y * ord(T[i + lp])) % p
    return H
    
def get_occurrences(pattern, text):
    answers = []
    p = 1000000007
    x = random.randint(1, p - 1)
    hashedPattern = PolyHash(pattern,p,x)
    hashedText = PreComputeHashes(text, len(pattern), p, x)
    for i in range(len(text) - len(pattern) + 1):
        if (hashedText[i] != hashedPattern):
            continue
        else:
            if (text[i:i + len(pattern)] == pattern):
                answers.append(i)
    return answers
if __name__ == '__main__':
    print_occurrences(get_occurrences(*read_input()))

