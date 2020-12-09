package Yr2020.Day08;

import java.util.ArrayList;

public class Console {
    private boolean infLoop = false;
    private int acc = 0;
    private int pc = 0;
    private ArrayList<String> program = new ArrayList<>();
    private ArrayList<Integer> instructionsRun = new ArrayList<>();

    public Console(ArrayList<String> program) {
        this.program = program;
    }

    private void acc(String action) {
        this.acc += Integer.parseInt(action);
    }

    private void jmp(String action) {
        this.pc += Integer.parseInt(action);
    }

    public void runProgram() {
        boolean run = true;

        while(run) {
            if (instructionsRun.contains(this.pc)) {
                this.infLoop = true;
                run = false;
            } else if(this.pc > this.program.size()-1) {
                run = false;
            } else {
                String[] instruction = this.program.get(this.pc).split(" ");
                this.instructionsRun.add(pc);
                switch(instruction[0]) {
                case "acc":
                    this.acc(instruction[1]);
                    this.pc++;
                    break;
                case "jmp":
                    this.jmp(instruction[1]);
                    break; 
                case "nop":
                    this.pc++;
                    break;
                }
            }
        }
    }

    public ArrayList<String> getProgram() {
        return this.program;
    }

    public void updateProgramLine(int lineId, String instruction) {
        this.program.set(lineId, instruction);
    }

    public int getAcc() {
        return this.acc;
    }

    public boolean isInfiniteLoop() {
        return this.infLoop;
    }

    public void resetPC() {
        this.pc = 0;
    }

    public void resetACC() {
        this.acc = 0;
    }

    public void reset() {
        this.infLoop = false;
        this.instructionsRun.clear();
        this.resetPC();
        this.resetACC();
    }
}
