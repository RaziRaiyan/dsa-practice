package LowLevelDesign.ParkingLot.model;

import java.util.List;


class ParkingLot {
    String id;
    List<ParkingFloor> floors;
    List<Gate> gates;
    ParkingManager manager;
  
    ParkingTicket assignTicket(Vehicle vehicle){
        return null;
    }
    void processExit(ParkingTicket ticket){
        return;
    }
}
  