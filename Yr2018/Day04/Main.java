package Yr2018.Day04;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Utils.InputReader;

public class Main {
    public static void main(String[] args) {
        InputReader iReader = new InputReader(System.getProperty("user.dir") + "/Day04/input.txt");
        iReader.loadFile();

        ArrayList<Event> el = new ArrayList<>();
        String line;
        while ((line = iReader.readLine()) != null) {
            el.add(new Event(line));
        }

        Collections.sort(el);

        Pattern p = Pattern.compile("#(\\d+)");

        HashMap<Integer, Guard> guards = new HashMap<>();
        int lastGuardId = 0;
        LocalDateTime startSleep = null;
        LocalDateTime endSleep = null;
        for(Event e : el) {
            Matcher m = p.matcher(e.getEvent());
            if(m.find()) {
                lastGuardId = Integer.valueOf(m.group(1));
                if (!guards.containsKey(lastGuardId)) {
                    Guard tmpGuard = new Guard(lastGuardId);
                    tmpGuard.addShift(e.getDate());
                    guards.put(lastGuardId, tmpGuard);
                } else {
                    guards.get(lastGuardId).addShift(e.getDate());
                }        
            } else if (e.getEvent().startsWith("falls")) {
                startSleep = e.getDate();
            } else {
                endSleep = e.getDate();
                Shift cShift = guards.get(lastGuardId).getLastShift();
                cShift.addSleep(startSleep.getMinute(), endSleep.getMinute());
            }
        }

        int sleepyGuardId = 0;
        int sleepyGuardTime = 0;
        for (Guard g : guards.values()) {
            int guardSleep = g.getTotalSleep();
            if (guardSleep > sleepyGuardTime) {
                sleepyGuardTime = guardSleep;
                sleepyGuardId = g.getGuardId();
            }
        }

        int sleepiestMin = guards.get(sleepyGuardId).getCommonSleepMinute();

        System.out.println("Sleepiest Guard: " + sleepyGuardId);
        System.out.println("Slept for: " + sleepyGuardTime);
        System.out.println("Sleepiest minute: " + sleepiestMin);
        System.out.println("AoC Answer pt1: " + sleepyGuardId * sleepiestMin);

        int freqOfMin = 0;
        int mostFreqMin = 0;
        int mostFreqMinGuardId = 0;
        for (Guard g : guards.values()) {
            if (g.getMosm() > freqOfMin) {
                freqOfMin = g.getMosm();
                mostFreqMin = g.getCommonSleepMinute();
                mostFreqMinGuardId = g.getGuardId();
            }
        }

        System.out.println("AoC Answer pt1: " + mostFreqMinGuardId*mostFreqMin);

    }
}
