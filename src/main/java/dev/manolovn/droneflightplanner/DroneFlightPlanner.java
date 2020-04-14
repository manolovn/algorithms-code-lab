package dev.manolovn.droneflightplanner;

public class DroneFlightPlanner {

    /*
       x    y   z
      [0,   2, 10] -> total 0
      [3,   5,  0] -> gains 10 (0-10); total = 10
      [9,  20,  6] -> burns 6 ; total = 4
      [10, 12, 15] -> burns 15 ; total = -11 <-- max
      [10, 10,  8] -> gain 8 ; total -3

      z+1 : -1
      z-1 : +1
    */
    public static int calcDroneMinEnergy(int[][] route) {
        int sE = route[0][2]; // start energy
        for (int i = 1; i < route.length; i++) {
            sE = Math.max(sE, route[i][2]);
        }
        return sE - route[0][2];
    }
}
