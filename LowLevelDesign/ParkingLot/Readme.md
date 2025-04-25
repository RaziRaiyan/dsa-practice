# 🅿️ Parking Lot System Design

A complete Low-Level Design (LLD) of a **Parking Lot System** built using **Object-Oriented Programming (OOP)** principles and **Strategy Pattern** for flexible billing logic.

---

## 📌 Features

- Support for multiple vehicle types: `Car`, `Bike`, `Truck`
- Different parking spot types: `Compact`, `Large`, `Bike`
- Parking lot with multiple floors
- Ticket generation on entry
- Exit with billing based on duration and vehicle type
- Dynamic billing using the Strategy Design Pattern
- Weekend vs Weekday billing logic
- Pluggable config-driven billing strategy

---

## 🧱 Project Structure

```
parkinglot/
├── Main.java                     # Entry point to simulate the 
├── model/
│   ├── Vehicle.java
│   ├── Car.java
│   ├── Bike.java
│   ├── Truck.java
│   ├── ParkingSpot.java
│   ├── CompactSpot.java
│   ├── BikeSpot.java
│   ├── LargeSpot.java
│   ├── ParkingTicket.java
│   ├── ParkingFloor.java
│   ├── ParkingLot.java
│   └── enums/
│       ├── VehicleType.java
│       ├── ParkingSpotType.java
│       ├── PaymentStatus.java
│       └── GateType.java (optional)
├── strategy/
│   ├── BillingStrategy.java
│   ├── FlatRateBilling.java
│   ├── HourlyRateBilling.java
│   ├── WeekendAwareBilling.java
│   └── ConfigurableBillingStrategy.java
├── config/
│   └── billing-rules.json        # Optional for external billing config
├── util/
│   └── JsonLoader.java           # Reads billing config
├── exception/
│   └── NoSpotAvailableException.java
└── README.md
```

---

## 🚀 How to Run

1. Clone the repo
2. Open in any Java IDE or run via CLI
3. Run `Main.java` to simulate parking flow:
   - Assign spot to vehicle
   - Generate ticket
   - Calculate fee using billing strategy on exit

---

## 🧠 Design Concepts Used

- ✅ Object-Oriented Design (OOP)
- ✅ SOLID Principles
- ✅ Strategy Design Pattern
- ✅ Extensibility for new rules/features
- ✅ Clean modular class design

---

## 🧩 Billing Strategies Supported

- `FlatRateBilling`: Same price for all
- `HourlyRateBilling`: Per-hour rate based on vehicle
- `WeekendAwareBilling`: Higher fee on weekends
- `ConfigurableBillingStrategy`: Load custom rules from JSON or DB

---

## ✅ Extension Ideas

- Admin module to manage slots/floors
- Store data in a DB (e.g., MySQL or SQLite)
- REST API layer using Spring Boot
- UI for vehicle entry/exit simulation
- Support for VIP/Reserved spots or EV charging

---

## 🙌 Author

Designed & implemented with ❤️ by [Your Name]

---

## 📜 License

This project is licensed under the MIT License.
