
sumOfNumbers = 0
maximum = 0
start = -1
end = -1
tempI = 0

arr = [-2, -4, -1, -2, -7, -3, -4, -8, -4, -2]

#Finds the maximum continous sum of an array in linear time along with the start and end index
for i, x in enumerate(arr):
    if sumOfNumbers + x < 0:
        tempI = i+1
        sumOfNumbers = 0
    else:
        sumOfNumbers += x

    if sumOfNumbers > maximum:
        start = tempI
        end = i
        maximum = sumOfNumbers

print("The maximum sum is", maximum)
print(f"The start index is {start+1} and the end index is {end+1}")