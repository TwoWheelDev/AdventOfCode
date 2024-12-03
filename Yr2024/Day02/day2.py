import copy
import os


def main():
    lines = loadInput('2024/Day02/input')
    safeReps1 = part1(lines)
    safeReps2 = part2(lines)
    print("Part 1:", safeReps1)
    print("Part 2:", safeReps2)


def loadInput(filename):
    output = None
    filename = os.getcwd() + '/' + filename
    with open(filename) as f:
        output = f.readlines()

    for i in range(len(output)):
        output[i] = output[i].strip()

    return output

def testReport(report: list):
    incDec = None
    reportIsSafe = False
    for i in range(len(report)-1):
        curLevel = int(report[i])
        nxtLevel = int(report[i+1])
        diff = abs(nxtLevel - curLevel)

        if (diff not in range(1, 4)):
            reportIsSafe = False
            break

        if (nxtLevel > curLevel):
            if (incDec is None):
                incDec = 'inc'
            elif (incDec != 'inc'):
                reportIsSafe = False
                break
            else:
                reportIsSafe = True

        if (nxtLevel < curLevel):
            if (incDec is None):
                incDec = 'dec'
            elif (incDec != 'dec'):
                reportIsSafe = False
                break
            else:
                reportIsSafe = True

    return reportIsSafe

def applyDampner(report: list, idToRemove):
    report.pop(idToRemove)
    return testReport(report)

def part1(reports):
    safeReports = 0
    for report in reports:
        levels = report.split(" ")
        reportIsSafe = testReport(levels)

        # If reportIsSafe
        if (reportIsSafe):
            safeReports += 1

    return safeReports

def part2(reports):
    safeReports = 0
    for report in reports:
        levels = report.split(" ")
        reportIsSafe = testReport(levels)

        # If reportIsSafe
        if (reportIsSafe):
            safeReports += 1
        else:
            for i in range(len(levels)):
                levels = report.split(" ")
                reportIsSafe = applyDampner(levels, i)

                if (reportIsSafe):
                    safeReports += 1
                    break

    return safeReports

if __name__ == "__main__":
    main()