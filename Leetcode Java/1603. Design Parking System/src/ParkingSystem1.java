public class ParkingSystem1 {
    private int[] arr;
    public ParkingSystem1(int big, int medium, int small) {
        arr = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        if (arr[carType - 1] > 0) {
            arr[carType - 1]--;
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        ParkingSystem1 parkingSystem1 = new ParkingSystem1(1, 1, 0);
        System.out.println(parkingSystem1.addCar(1));
        System.out.println(parkingSystem1.addCar(2));
        System.out.println(parkingSystem1.addCar(3));
        System.out.println(parkingSystem1.addCar(1));
    }
}