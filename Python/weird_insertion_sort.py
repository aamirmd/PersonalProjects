a = [1, 2, 3, 8, 4, 5, 6, 7, 9, 10]
i = 4
j = 9
num = 8

#Trying to sort an array which is almost sorted except for one misplaced element using the fewest number of comparisons
def binary_search(num, i, j):
    while i != j:
        m = (i + j)//2

        if a[m] > num:
            j = m-1
        elif a[m] < num:
            i = m+1
        else:
            i = m
            j = m
    return m
for n in range(1, 10):
    if a[n] < a[n-1]:
        if a[n-1] <= a[n+1]:
            c = a[n]
            i = 0
            j = n-1
        else:
            c = a[n-1]
            i = n
            j = a.__len__()-1

j = binary_search(c, i, j)

while i != j:
    a[i-1] = a[i]
    i += 1
a[j-1] = c
print(a)


print("The index is", i, j)