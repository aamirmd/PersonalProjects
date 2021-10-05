nameNumber = {"Pulisic":10, "Lukaku":9, "Mount":19, "Kepa":1, "Silva":6}
numberName = {10:"Pulisic", 9:"Lukaku", 19:"Mount", 1:"Kepa", 6:"Silva"}
print("Enter 1 for name:number and 2 for number:name")
print("Enter your choice")
choice = int(input())

if choice == 1:
    print("Enter the name of the player")
    name = input()
    if nameNumber.keys().__contains__(name):
        print("The number of the player is", nameNumber[name])
    else:
        print("Invalid name")
elif choice == 2:
    print("Enter the number of the player")
    number = int(input())
    if number in numberName.keys():
        print("The name of the player is", numberName[number])
    else:
        print("Invalid number")
else:
    print("Invalid choice")