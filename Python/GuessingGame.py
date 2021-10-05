import random

print("Welcome to the guessing game")
n = random.randint(1, 100)
numGuesses = 0
while True:
    numGuesses = numGuesses + 1
    if numGuesses > 9:
        print("Sorry, you have lost your guesses")
        break
    print("Enter your guess")
    guess = int(input())
    if guess > n:
        print("Number is too big, guess smaller")
    elif guess < n:
        print("Number is too small, guess bigger")
    else:
        print(f"Congratulations, you took {numGuesses} guesses")
        break
    print(f"You have {9-numGuesses} guesses left")