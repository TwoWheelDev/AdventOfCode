package Yr2020.Day01;

import java.util.ArrayList;

public class Day01 {
    private ArrayList<String> expenseReport = new ArrayList<>();

    public void loadExpenses(ArrayList<String> expenses) {
        this.expenseReport = expenses;
    }

    public int runPart1() {
        int number1 = 0;
        int number2 = 0;
        boolean foundNumbers = false;

        for (int i=0; i<this.expenseReport.size()-1; i++) {
            number1 = Integer.valueOf(this.expenseReport.get(i));
            for (int j=0; j<this.expenseReport.size(); j++) {
                number2 = Integer.valueOf(this.expenseReport.get(j));
                if (number1+number2 == 2020) {
                    foundNumbers = true;
                    break;
                }
            }
            
            if (foundNumbers) break;
        }

        return number1*number2;
    }

    public int runPart2() {
        int number1 = 0;
        int number2 = 0;
        int number3 = 0;
        boolean foundNumbers = false;

        for (int i=0; i<this.expenseReport.size()-1; i++) {
            number1 = Integer.valueOf(this.expenseReport.get(i));
            for (int j=0; j<this.expenseReport.size(); j++) {
                number2 = Integer.valueOf(this.expenseReport.get(j));
                for (int k=0; k<this.expenseReport.size(); k++) {
                    number3 = Integer.valueOf(this.expenseReport.get(k));
                    if (number1+number2+number3 == 2020) {
                        foundNumbers = true;
                        break;
                    }
                }
                if (foundNumbers) break;
            }
            
            if (foundNumbers) break;
        }

        return number1*number2*number3;
    }
}
