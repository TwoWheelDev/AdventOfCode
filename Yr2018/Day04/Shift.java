package Yr2018.Day04;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class Shift {
    private ArrayList<String> shiftLog;
    private LocalDateTime shiftDate;

    public Shift(LocalDateTime shiftDate) {
        this.shiftDate = shiftDate;
        this.shiftLog = new ArrayList<>();

        for (int i=0; i<60; i++) {
            this.shiftLog.add(".");
        }
    }

    public ArrayList<String> getShiftLog() {
        return this.shiftLog;
    }

    public LocalDateTime getShiftDate() {
        return this.shiftDate;
    }

    public void addSleep(int start, int end) {
        for (int i = start; i<end; i++) {
            this.shiftLog.set(i, "#");
        }
    }

    public int getSleepTime() {
        return Collections.frequency(this.shiftLog, "#");
    }
}
