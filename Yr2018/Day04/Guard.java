package Yr2018.Day04;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class Guard {
    private int guardId;
    private ArrayList<Shift> shifts = new ArrayList<>();
    private int mostOftenSleptMin;
    private int mosn_freq;

    public Guard(int guardId) {
        this.setGuardId(guardId);
    }

    public void setGuardId(int guardId) {
        this.guardId = guardId;
    }

    public int getGuardId() {
        return this.guardId;
    }

    public ArrayList<Shift> getShiftList() {
        return this.shifts;
    }

    public Shift getLastShift() {
        return this.shifts.get(this.shifts.size()-1);
    }

    public void addShift(LocalDateTime date) {
        this.shifts.add(new Shift(date));
    }

    public int getNumShifts() {
        return this.getShiftList().size();
    }

    public int getTotalSleep() {
        int totalSleep = 0;
        for (Shift s: this.shifts) {
            totalSleep += s.getSleepTime();
        }

        return totalSleep;
    }

    public ArrayList<Integer> getSleepMinFreq() {
        ArrayList<Integer> sleepMins = new ArrayList<>();
        for (int i = 0; i < 60; i++) sleepMins.add(0);

        for(Shift s: this.shifts) {
            ArrayList<String> sLog = s.getShiftLog();
            for (int i = 0; i < sLog.size(); i++) {
                if (sLog.get(i).equals("#")) sleepMins.set(i, sleepMins.get(i) + 1);
            }
        }

        return sleepMins;
    }

    public int getMosm() {
        if (this.mosn_freq == 0|| this.mostOftenSleptMin == 0) {
            this.calculateMOSM();
        }
        return this.mosn_freq;
    }

    public int getCommonSleepMinute() {
        if (this.mosn_freq == 0|| this.mostOftenSleptMin == 0) {
            this.calculateMOSM();
        }

        return this.mostOftenSleptMin;
    }

    private void calculateMOSM() {
        ArrayList<Integer> sleepMins = this.getSleepMinFreq();
        
        this.mosn_freq = Collections.max(sleepMins);
        this.mostOftenSleptMin = sleepMins.indexOf(this.mosn_freq);

    }
}
