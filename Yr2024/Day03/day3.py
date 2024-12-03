import os
import re


def main():
    lines = loadInput('2024/Day03/input')
    print("Part 1:", part1(lines))
    print("Part 2:", part2(lines))



def loadInput(filename):
    output = None
    filename = os.getcwd() + '/' + filename
    with open(filename) as f:
        output = f.readlines()

    for i in range(len(output)):
        output[i] = output[i].strip()

    return output

def part1(lines):
    total = 0
    for line in lines:
        pattern = r'mul\((\d+,\d+)\)'
        validMuls = re.findall(pattern, line)

        for mul in validMuls:
            x,y = mul.split(",")
            total += int(x) * int(y)
    
    return total

def part2(lines):
    total = 0
    multEnabled = True

    for line in lines:
        pattern = r'(do\(\))|(don\'t\(\))|mul\((\d+,\d+)\)'
        matches = re.findall(pattern, line)

        for match in matches:
            if (match[0] == "do()"):
                multEnabled = True
            elif (match[1] == "don't()"):
                multEnabled = False
            else:
                x,y = match[2].split(",")
                total += int(x) * int(y) if multEnabled else 0
    
    return total


if __name__ == "__main__":
    main()