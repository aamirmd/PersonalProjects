print("Enter a number")
x = int(input())
print("Enter 1 for normal and 0 for upside down")
o = int(input())

if o == 1:
    for i in range(0, x):
        for j in range(0, x):
            if j > i:
                print(" ", end="")
            else:
                print("*", end="")
        print()
elif o == 0:
    for i in range(0, x):
        for j in range(0, x):
            if j > (x-i-1):
                print(" ", end="")
            else:
                print("*", end="")
        print()
else:
    print("Invalid choice")




