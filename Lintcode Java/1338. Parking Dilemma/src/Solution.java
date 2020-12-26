import java.util.Arrays;

public class Solution {
    /**
     * @param cars: integer array of length denoting the parking slots where cars are parked
     * @param k:    integer denoting the number of cars that have to be covered by the roof
     * @return: return the minium length of the roof that would cover k cars
     */
    public int ParkingDilemma(int[] cars, int k) {
        // write your code here
        Arrays.sort(cars);
        
        int res = cars[cars.length - 1] - cars[0] + 1;
        for (int i = 0; i + k - 1 < cars.length; i++) {
            res = Math.min(res, cars[i + k - 1] - cars[i] + 1);
        }
        
        return res;
    }
}
