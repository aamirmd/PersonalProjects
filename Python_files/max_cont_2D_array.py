s = 0
maximum = 0

arr = [[1, -1, 0, 0, -4],
       [2, 3, -2, -3, 2],
       [4, 1, -1, 5, 0],
       [3, -2, 1, -3, 2],
       [-3, 2, 4, 1, -4]]

#arr = [[0, 10, 0], [-1, 0, 100], [10, -100, 10]]
n = arr[0].__len__()
m = arr.__len__()

#Finds the maximum continous 2D sum of a torus
for i in range(0, m):
    for a in range(0, n):
        for j in range(i, m+i-1):
            for b in range(a, a + n - 1):
                s = 0
                for k in range(i, j+1):
                    for c in range(a, b+1):
                        s += arr[k % 5][c % 5]
                maximum = max(maximum, s)





#
# m = 0
# s = 0
# arr = [-2, 4, 1, -2, 7, -3, -4, 8, -4, 2]
# for i in range(0, 10):
#     for j in range(i, 10):
#         s = 0
#         for k in range(i, j):
#             s += arr[k]
#         m = max(s, m)
#
print("m = ", maximum)