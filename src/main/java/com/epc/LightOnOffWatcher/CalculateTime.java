package com.epc.LightOnOffWatcher;


import java.util.Arrays;

public class CalculateTime {
    private static final int start_date = 5;
    private static final String[][] groupSequence = {
            {"A", "B", "C", "A", "B", "C+A"},
            {"B", "C", "A", "B", "C", "A+B"},
            {"C", "A", "B", "C", "A", "B+C"}
    };
    private static final String[] timeSequence = {
            "5:00 to 9:00",
            "9:00 to 13:00",
            "13:00 to 17:00",
            "17:00 to 21:00",
            "21:00 to 1:00",
            "1:00 to 5:00"
    };


    public  String[] calculate(int day,String group) {
        int start_index_For_Loop = 0;
        int start_index = 0;
        int start_index2 = 0;
        int startDate = 5;
        do{
            if(start_index_For_Loop == 3) {
                start_index_For_Loop = 0;
            }
            if(startDate == day ) {
                String arrayString = Arrays.toString(groupSequence[start_index_For_Loop]);
                return  getTimesFromArray(start_index_For_Loop,group);
            }
            startDate++;
            start_index++;
            start_index_For_Loop++;
        }while(day >= startDate);
        return null;
    }

    private static String[] getTimesFromArray(int outerArrayIndex,String groupName) {
        String[] timesForSpecificGroup = new String[groupSequence[outerArrayIndex].length];
        int getTimesCount = 0;
        for(int i = 0; i <= groupSequence[outerArrayIndex].length-1; i++) {
            if(groupSequence[outerArrayIndex][i].equals(groupName) || groupSequence[outerArrayIndex][i].contains(groupName)) {
                timesForSpecificGroup[i] = timeSequence[i];
                getTimesCount++;
            }
        }
        String[] fixArray = new String[getTimesCount];
        getTimesCount = 0;
        for(int i = 0;i <= timesForSpecificGroup.length-1; i++) {
            if(timesForSpecificGroup[i] != null) {
                fixArray[getTimesCount] = timesForSpecificGroup[i];
                getTimesCount++;
            }
        }
        return fixArray;
    }
}
