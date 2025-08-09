# 🚗 Car Renter System

A simple **Java console application** for renting and returning cars, managing customer data, and tracking rental records.  
Perfect for learning **OOP concepts in Java**! ☕💻

---

## 📦 Features
- 🛻 **Rent a Car** – Select a car, set rental days, view total price, and confirm.
- 🔄 **Return a Car** – Enter the car ID to return and mark it available again.
- 🧾 **Manage Records** – Tracks **cars**, **customers** (with auto-assigned IDs), and **rentals**.
- 📋 **Interactive Menu** – Easy step-by-step rental process.

---

## 📂 Project Structure
```

📦 Car-Renter-System
┣ 📜 Main.java
┣ 📜 CarRentalSystem.java
┣ 📜 Car.java
┣ 📜 Customer.java
┣ 📜 Rental.java
┗ 📜 README.md

````

---

## 🚀 Getting Started

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/Minsu-Agrahari/Car-Renter-System.git
cd Car-Renter-System
````

### 2️⃣ Compile the Code

```bash
javac Main.java
```

### 3️⃣ Run the Application

```bash
java Main
```

---

## 🖥️ How It Works

1. **Menu Options**

   * `1` ➡ Rent a Car
   * `2` ➡ Return a Car
   * `3` ➡ Exit

2. **Renting**

   * Enter your name
   * Choose a car by ID (e.g., `C001`)
   * Set the rental days
   * Confirm rental ✅

3. **Returning**

   * Enter the car ID to return
   * System validates and processes return

---

## 💡 Example Run :- 

```
==== Car Rental System ====
1. Rent a Car
2. Return a Car
3. Exit

 -> Enter Your Choice :- 1
 -> Enter your name :- John

Available Cars:
 -> C001 - Camry - Toyota - 60.0 - true
 -> C002 - Accord - Honda - 70.0 - true

Enter the car ID you want to rent :- C001
Enter the number of days :- 3

 == Rental Information ==
Customer ID: CUS1
Car: Camry Toyota
Rental Days: 3
Total Price $180.00
Confirm rental (Y/N)... Y

Car rented Successfully! 🎉
```

---

## 🛠️ Future Improvements

* 💾 Save data to a file or database
* ⚠️ Better error handling
* 🧹 Code refactoring for cleaner structure
* 🎨 Add colors to console output

---

## 📜 License

This project is licensed under the **MIT License**.

---

## 👤 Author

**Minsu Agrahari**
🔗 [GitHub Profile](https://github.com/Minsu-Agrahari)
