# Assignment 1 — Builder Pattern (Gaming PC Configuration)

## Overview
This repository contains the implementation of Assignment 1 for the Software Design Patterns course. The project demonstrates the **Builder Pattern** in Java, enabling step-by-step object construction with domain validation and preset configurations.

## Features
- **Fluent Builder API:** Method chaining for readable object construction.
- **Validation Rules:** Includes single-field checks and cross-field dependency validation (e.g., RTX 4090 requires >= 850W PSU).
- **Director Presets:** Budget, Balanced, and Performance builds (Performance outputs 🍌 on creation).
- **Automated Tests:** 10 native test cases verifying build logic and constraints.

## Project Structure
- `src/GamingPC.java` — Target product and Builder logic.
- `src/Warranty.java` — Value object for warranty data.
- `src/PCDirector.java` — Director class with preset configurations.
- `src/Main.java` — Main entry point.
- `test/GamingPCTest.java` — Native Java automated tests.

## How to Run
1. **Main Program:** Run `src/Main.java`
2. **Automated Tests:** Run `test/GamingPCTest.java`