package LowLevelDesign.ParkingLot.model;

import LowLevelDesign.ParkingLot.model.enums.VehicleType;

abstract class Vehicle {
    protected String licenseNumber;
    protected VehicleType type;
}

class Car extends Vehicle {
    public Car() {
        super.type = VehicleType.CAR;
    }
}

class Bike extends Vehicle {
    public Bike() {
        super.type = VehicleType.BIKE;
    }
}

class Truck extends Vehicle {
    public Truck() {
        super.type = VehicleType.TRUCK;
    }
}