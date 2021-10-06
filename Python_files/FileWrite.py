print("Enter name of file")
name = input()
print("Enter whatever you want in the file. Type 'exit' to exit")
while(True):
    str = input()
    if str == "exit":
        break
    with open(name+".txt", "a") as f:
        f.write(str)
        f.write("\n")
print("Program has ended")
