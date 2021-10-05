import random

user_wins = "Congratulations, you won this round"
computer_wins = "Sorry, you lost this round"
tie = "It's a tie!"
choices = ["snake", "water", "gun"]

def increment(score):
    return score + 1

user_score = 0
computer_score = 0

print("Welcome to the snake/water/gun game. It is another version of the famous rock/paper/scissors game.")
print("Rules are simple. Snake drinks water, water destroys gun, gun kills snake.\n")
print("Let's play!!\n\n")

for x in range(0,10):
    computer_choice = random.choice(choices)
    user_choice = input("Enter your choice (should be all lowercase)\n")
    if not choices.__contains__(user_choice):
        print("Invalid input, computer wins")
        computer_score = increment(computer_score)
        continue
    print(f"Your choice was {user_choice} and computers choice was {computer_choice}")
    if computer_choice == "snake" and user_choice == "gun":
        output = user_wins
        user_score = increment(user_score)
    elif computer_choice == "gun" and user_choice == "snake":
        output = computer_wins
        computer_score = increment(computer_score)
    elif computer_choice == user_choice:
        output = tie
    else:
        if choices.index(user_choice) < choices.index(computer_choice):
            output = user_wins
            user_score = increment(user_score)
        else:
            output = computer_wins
            computer_score = increment(computer_score)

    print(output)
print(f"Your score was {user_score} and computer score was {computer_score}")
