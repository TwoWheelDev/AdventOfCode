import os


def main():
    lines = loadInput('2024/Day01/input')
    list1, list2 = processLines(lines)
    print('Part1:', part1(list1, list2))
    print('Part2:', part2(list1, list2))


def loadInput(filename):
    output = None
    filename = os.getcwd() + '/' + filename
    with open(filename) as f:
        output = f.readlines()

    for i in range(len(output)):
        output[i] = output[i].strip()

    return output

def processLines(lines):
    l1, l2 = list(), list()
    for line in lines:
        parts = line.split("   ")
        l1.append(parts[0])
        l2.append(parts[1])

    return l1, l2

def part1(list1, list2):
    list1.sort()
    list2.sort()

    total = 0

    for i in range(len(list1)):
        total += abs(int(list1[i]) - int(list2[i]))

    return total

def part2(list1: list, list2: list):
    total = 0

    for num in list1:
        x = list2.count(num)
        total += int(num) * x

    return total

if __name__ == "__main__":
    main()
