package LowLevelDesign.ParkingLot.model;

import LowLevelDesign.ParkingLot.model.enums.ParkingSpotType;
abstract class ParkingSpot {
    private final String id;
    private boolean isAvailable = true;
    private Vehicle parkedVehicle;

    public ParkingSpot(String id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void assignVehicle(Vehicle vehicle) {
        parkedVehicle = vehicle;
        isAvailable = false;
    }

    public void removeVehicle() {
        parkedVehicle = null;
        isAvailable = true;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
    
    public abstract ParkingSpotType getParkingSpotType();
}

class CompactSpot extends ParkingSpot {
    public CompactSpot(String id) {
        super(id);
    }

    @Override
    public ParkingSpotType getParkingSpotType() {
        return ParkingSpotType.COMPACT;
    }
}

class LargeSpot extends ParkingSpot {
    public LargeSpot(String id) {
        super(id);
    }

    @Override
    public ParkingSpotType getParkingSpotType() {
        return ParkingSpotType.LARGE;
    }
}

class BikeSpot extends ParkingSpot {
    public BikeSpot(String id) {
        super(id);
    }

    @Override
    public ParkingSpotType getParkingSpotType() {
        return ParkingSpotType.BIKE;
    }
}