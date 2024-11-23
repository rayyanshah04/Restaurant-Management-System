# Restaurant-Management-System
A command-line application built in Java using object-oriented programming principles. This system manages restaurant operations, including menu management, order processing, and price calculations. Designed as a beginner-friendly project, it focuses on functionality and simplicity for learning core programming concepts.

# Restaurant Management System

This is a **Restaurant Management System** command-line project implemented in Java using object-oriented programming principles. It allows restaurant staff to manage table assignments, take orders, calculate prices, and process payments.

---

## Requirements

To run the project, you need to have the following installed on your system:

1. **Git** - For cloning the repository.
2. **Java Development Kit (JDK)** - To compile and run the Java code.

---

## Installation & Setup

Follow the steps below to run the project on both Windows and Linux environments:

### Step 1: Clone the Repository

Run the following command in your terminal to clone the repository:

```bash
git clone https://github.com/rayyanshah04/Restaurant-Management-System.git
```

### Step 2: Move and Rename the Project Directory

Rename the cloned directory to `sem2Project` and navigate into it:

#### For Linux/WSL:
```bash
mv Restaurant-Management-System sem2Project
cd sem2Project
```
#### Windows (Command Prompt or PowerShell):
```powershell
rename Restaurant-Management-System sem2Project
cd sem2Project
```

### Step 3: Compile the Java Files

Compile the Java files using the `javac` command. Run the following in your terminal:

```bash
javac -d out -sourcepath . CalculatePrice/*.java GetOrder/*.java Menu/*.java Payment/*.java TableAssignment/*.java UserDetails/*.java Main.java
```

This command will compile all the Java files and place the class files in the `out` directory.

### Step 4: Run the Program

Once the compilation is complete, run the project with the following command:

```bash
java -cp out sem2Project.Main
```

This will execute the `Main` class of the project and run the restaurant management system.





