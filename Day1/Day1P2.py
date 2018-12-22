input = open("Day1.in")
lines = input.readlines()
seen = {}
total = 0
counter = 0
while True:
    counter += 1
    print("Iteration:", counter)
    for line in lines:
        total += int(line)
        if seen.get(total, None) is not None:
            print("Answer:", total)
            exit()

        seen[total] = True
        # print(seen)