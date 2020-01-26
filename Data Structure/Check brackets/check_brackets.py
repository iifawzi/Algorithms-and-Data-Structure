# python3
#Check_Brackets
def are_matching(left, right):
    return (left + right) in ["()", "[]", "{}"]


def find_mismatch(text):
    result = "Success"
    opening_brackets_stack = []
    for i, next in enumerate(text):
        if next in "([{":
            opening_brackets_stack.append([i,next])
            if (len(text) == 1):
                result = i+1
        if next in ")]}":
            if (len(opening_brackets_stack) > 0):
                if (are_matching(opening_brackets_stack[len(opening_brackets_stack)-1][1],next)):
                    opening_brackets_stack.pop()
                else:
                    result = i+1
                    break
            else:
                result = i+1
                break
    
    if ((len(opening_brackets_stack) == 1) and result == "Success"):
        result = opening_brackets_stack[0][0] + 1
    return result

def main():
    data = input()
    mismatch = find_mismatch(data)
    print(mismatch)
            


if __name__ == "__main__":
    main()
