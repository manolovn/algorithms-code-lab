package dev.manolovn.corporateflights;

/**
 * source: https://leetcode.com/problems/corporate-flight-bookings
 * difficulty: MEDIUM
 */
public class CorporateFlightsBooking {

    /**
     * Given m as the number of bookings (bookings.length) and n as the number of flights
     * Time:  O(m*n) ; in the worst case we have m bookings to all the n flights
     * Space: O(n) ; the size of the array given by the input n
     *
     * TODO: improve the solution. It's already accepted by leetcode but it's a brute force
     * implementation.
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] flights = new int[n];

        for (int[] booking : bookings) {
            int from = booking[0] - 1;
            int to = booking[1] - 1;
            int seats = booking[2];
            for (int j = from; j <= to; j++) {
                flights[j] += seats;
            }
        }

        return flights;
    }
}
