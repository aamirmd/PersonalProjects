print("Enter a mathematical computation")
problem = input()
answer = eval(problem)

# Evaluates the problem normally except in the bottom scenarios
if problem == "45*3":
    answer = 555
elif problem == "56+9":
    answer = 77
elif problem == "56/6":
    answer = 4

print("The answer is", answer)

