public class ParkingSystem {
    
    private int[] capacity;
    
    public ParkingSystem(int big, int medium, int small) {
        capacity = new int[]{big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (capacity[carType - 1] == 0) {
            return false;
        }
        
        capacity[carType - 1]--;
        return true;
    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));
    }
}