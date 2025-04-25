package LowLevelDesign.ParkingLot.model;

import java.time.LocalDateTime;

class ParkingTicket {
  private String ticketNumber;
  private LocalDateTime entryTime;
  private LocalDateTime exitTime;
  private double totalCost;

  public ParkingTicket(String ticketNumber, LocalDateTime entryTime) {
    this.ticketNumber = ticketNumber;
    this.entryTime = entryTime;
  }

  public void setExitTime(LocalDateTime exitTime) {
    this.exitTime = exitTime;
  }

  public void setTotalCost(double totalCost) {
    this.totalCost = totalCost;
  }

  public String getTicketNumber() {
    return ticketNumber;
  }

  public LocalDateTime getEntryTime() {
    return entryTime;
  }

  public double getTotalCost() {
    return totalCost;
  }

  public LocalDateTime getExitTime() {
    return exitTime;
  }
}