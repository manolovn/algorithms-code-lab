package dev.manolovn.studentattendancerecord;

/**
 * source: https://leetcode.com/problems/student-attendance-record-i/
 * difficulty: EASY
 */
public class StudentAttendanceRecord {

    public boolean checkRecord(String s) {
        int l = s.length();
        int absentCount = 0;
        int continousLate = 0;
        for (int i = 0 ; i < l ; i++) {
            if (s.charAt(i) == 'A') {
                absentCount++;
            }
            if (s.charAt(i) == 'L' &&
                    (i - 1 >= 0 && s.charAt(i-1) == 'L') &&
                    (i + 1 < l && s.charAt(i+1) == 'L')) {
                continousLate++;
            }
        }
        return !(absentCount > 1 || continousLate > 0);
    }
}
