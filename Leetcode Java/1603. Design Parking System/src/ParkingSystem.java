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
}