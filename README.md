# 📞 Phone Directory Application

A desktop-based contact management system developed in **Java** utilizing **Java Swing** for the graphical user interface and **SQLite** for lightweight, persistent relational storage.

---

## 📋 Table of Contents
- [Overview](#-overview)
- [✨ Key Features](#-key-features)
- [🛠️ Technologies Used](#️-technologies-used)
- [🏛️ Architecture & Project Structure](#️-architecture--project-structure)
- [🚀 How to Run](#-how-to-run)
  - [Prerequisites](#prerequisites)
  - [Running via Command Line](#running-via-command-line)
  - [Running in an IDE](#running-in-an-ide-intellij-idea--netbeans--eclipse)
- [🖼️ Screenshots](#️-screenshots)
- [👥 Contributors & Credits](#-contributors--credits)

---

## 📖 Overview

**Phone Directory** is a desktop application designed to streamline personal and professional contact management. It provides a visual dashboard to store, inspect, update, search, and print contact information with built-in database validations.

The application adheres to clean object-oriented design and separates concerns between database communication, domain entities, custom UI components, and static multimedia assets.

---

## ✨ Key Features

- **➕ Add Contacts**: Create new contact records with first name, last name, mobile number, job title, and email address.
- **🔍 Search Contacts**: Quickly look up contacts by mobile number and inspect matched entries in a structured tabular view.
- **✏️ Two-Step Update Wizard**: Safely modify existing records by querying a phone number and populating contact fields for editing.
- **🗑️ Delete Contacts**: Search and remove contact records from the database with confirmation.
- **📊 View All Contacts**: Browse all saved contacts in an interactive `JTable` view.
- **🖨️ Print Contacts**: Generate hard-copy records or print-to-PDF directly from the table using native Java printing utilities.
- **🛡️ Data Integrity & Validation**:
  - Enforces unique constraints on mobile numbers and email addresses.
  - Validates email formats (`@` and `.com` domain checks).
- **🎨 Custom UI Components**:
  - Styled rounded buttons (`Jbutton`, `JbuttonM`, `JbuttonMM`) with custom painting and border rendering.
  - Styled text boxes (`JTextBox`) for a consistent modern aesthetic.
  - Real-time contact counter badge on the main dashboard.
- **🎵 Multimedia Integration**:
  - Quick action to trigger external media/audio playback.
  - Browser integration for direct email client access.

---

## 🛠️ Technologies Used

- **Programming Language**: Java (SE 8+ / Java 21)
- **GUI Framework**: Java Swing & AWT (`JFrame`, `JTable`, `JScrollPane`, `Graphics2D`)
- **Database Engine**: [SQLite](https://www.sqlite.org/) (File-based: `WorkHard.db`)
- **Database Driver**: [SQLite JDBC Driver](https://github.com/xerial/sqlite-jdbc) (e.g., `sqlite-jdbc-3.20.1.jar`)
- **Build & Project Tools**: Apache Ant (`build.xml`), NetBeans Project Metadata, IntelliJ IDEA (`.iml`)

---

## 🏛️ Architecture & Project Structure

The project has been organized with a clean asset decoupling strategy, isolating all graphic icons and sound effects into a dedicated `assets/` directory while keeping core logic structured into specialized packages:

```text
PhoneDirectory4/
├── assets/                       # Reorganized media assets (images & audio)
│   ├── about.png
│   ├── add.png
│   ├── adding.png
│   ├── back.png
│   ├── Back.wav
│   ├── delete.png
│   ├── deleteing.png
│   ├── email.png
│   ├── exit.png
│   ├── go.wav
│   ├── icon_main.png
│   ├── main.png
│   ├── print.png
│   ├── search.png
│   ├── searching.png
│   ├── show.png
│   ├── sound.png
│   ├── Untitled(1).png
│   ├── update.png
│   └── updateing.png
├── src/                          # Java source code
│   ├── DataBase/
│   │   └── Main.java             # Database connection, queries & CRUD logic
│   ├── DBTable/
│   │   └── Einsert.java          # Contact model / POJO entity
│   └── phonedirectory/
│       ├── About.java            # About dialog & credits
│       ├── Add.java              # Add contact view
│       ├── Delete.java           # Delete contact view
│       ├── Jbutton.java          # Custom base rounded button
│       ├── JbuttonM.java         # Custom button with icon & primary color theme
│       ├── JbuttonMM.java        # Custom secondary button with icon
│       ├── JTextBox.java         # Custom rounded text input field
│       ├── Phone.java            # Main application dashboard
│       ├── PhoneDirectory.java   # Main class entry point
│       ├── Search.java           # Search entry prompt view
│       ├── Search_Contacts.java  # Search results table view
│       ├── Table.java            # Full contact directory table view
│       ├── tablePrint.java       # Printable contact table view
│       ├── UpdateOne.java        # Update step 1: Query phone number
│       └── UpdateTwo.java        # Update step 2: Modify contact fields
├── build.xml                     # Apache Ant build script
├── manifest.mf                   # Manifest file for JAR packaging
├── WorkHard.db                   # SQLite database storage file
├── utomp3.mp3                    # Audio track for media playback
└── README.md                     # Project documentation
```

### Architectural Layering

1. **Presentation Layer (`src/phonedirectory/`)**: Handles UI rendering, user interaction events, form validations, and navigation between screens.
2. **Business / Data Access Layer (`src/DataBase/`)**: Encapsulates JDBC connections, SQL statement preparation (`INSERT`, `SELECT`, `UPDATE`, `DELETE`), and database constraint error translations.
3. **Domain Layer (`src/DBTable/`)**: Holds the `Einsert` data transfer object representing a contact record.
4. **Asset Layer (`assets/`)**: Self-contained repository of icons, UI banners, and sound effects referenced uniformly via file paths across all frames.

---

## 🚀 How to Run

### Prerequisites

1. **Java Development Kit (JDK)**: JDK 8 or higher (JDK 17 or JDK 21 recommended). Verify your installation:
   ```bash
   java -version
   javac -version
   ```
2. **SQLite JDBC Driver**: Ensure the SQLite JDBC jar (such as `sqlite-jdbc-3.20.1.jar` or higher) is available in your classpath.

---

### Running via Command Line

1. **Clone or Navigate to the Project Root**:
   ```bash
   cd path/to/PhoneDirectory4
   ```

2. **Compile the Source Files**:
   Compile all Java source files and specify the path to your SQLite JDBC driver:
   ```bash
   # Windows (PowerShell / CMD):
   javac -d build/classes -cp "path/to/sqlite-jdbc.jar" (Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object { $_.FullName })
   ```
   *Alternatively, if using standard wildcard syntax:*
   ```bash
   javac -d build/classes -cp "path/to/sqlite-jdbc.jar" src/DataBase/*.java src/DBTable/*.java src/phonedirectory/*.java
   ```

3. **Launch the Application**:
   Run the main entry class (`phonedirectory.PhoneDirectory`) from the project root so the `assets/` folder and `WorkHard.db` database are correctly resolved:
   ```bash
   java -cp "build/classes;path/to/sqlite-jdbc.jar" phonedirectory.PhoneDirectory
   ```

---

### Running in an IDE (IntelliJ IDEA / NetBeans / Eclipse)

1. Open the project folder (`PhoneDirectory4`) in your preferred IDE.
2. Add the SQLite JDBC `.jar` to the project's dependencies:
   - **IntelliJ IDEA**: `File` ➔ `Project Structure` ➔ `Libraries` ➔ Click `+` ➔ Select your SQLite JDBC `.jar`.
   - **NetBeans**: Right-click `Libraries` in the Project Explorer ➔ `Add JAR/Folder` ➔ Select your SQLite JDBC `.jar`.
3. Set the working directory of your Run Configuration to the **project root folder** (`PhoneDirectory4`).
4. Select `phonedirectory.PhoneDirectory` as the main class and click **Run**.

---

## 🖼️ Screenshots

> Replace the placeholder image paths below with actual screenshots of your application UI.

### Main Dashboard
![Main Dashboard](/images/Main.jpg)
*The central control panel displaying action buttons and live contact count.*

### Add Contact Screen
![Add Contact Form](/images/add.jpg)
*Form for adding a new contact with field validation.*

### Search Contacts
![Search Result View](/images/search.jpg)
*Query contacts by mobile number with immediate result feedback.*

### Update Contact Wizard
![Update Contact Screen](/images/update.jpg)
*Two-step update workflow for modifying contact details.*

---

## 👥 Contributors & Credits

- **Hosam Zakaria**
- **Ahmed Mahmoud**
- **Mohamed Zakaria**
- **Nehad Mohamed**
- **Fady Moawad**
- **Habiba Mohsen**

*Version: 1.1.25*

