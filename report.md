README.md
Assignment 1 — Builder Pattern (Gaming PC Configuration)

About
This project is for Assignment 1 in Software Design Patterns. It shows how the Builder Pattern works in Java using a Gaming PC example. It allows building a PC step by step with validation and ready presets.

Main Features

Fluent Builder API for easy method chaining.

Validation for parameters, including single-field checks and dependent rules like RTX 4090 requiring at least 850W PSU.

Director with Budget, Balanced, and Performance presets.

10 automated tests covering valid builds, invalid data, boundaries, and builder reuse.

Project Files

src/GamingPC.java: Main class and Builder logic.

src/Warranty.java: Warranty class.

src/PCDirector.java: Presets for PC configurations.

src/Main.java: Main class to run the program.

test/GamingPCTest.java: Test suite with 10 tests.

How to Run

Run src/Main.java to test PC construction.

Run test/GamingPCTest.java to execute automated tests.

report.md
Assignment 1 Report: Builder Pattern

Domain and Constraints

Domain: Gaming PC Construction

Constraint 1: RTX 4090 GPU needs a Power Supply of at least 850W

Constraint 2: Liquid Cooling needs a Power Supply of at least 600W

Preset: PERFORMANCE build prints a banana emoji in console when built

Part A - Problems with Conventional Construction

Telescoping Constructor: Having 10+ parameters in one constructor makes it hard to read and hard to pass arguments correctly.

Positional Parameter Errors: It is easy to accidentally swap values of the same type, like RAM and Power Supply integers.

Complex Validation: Putting multi-field validation inside a big constructor makes the code messy and hard to maintain.

Part C - Validation Rules

Single-field: RAM must be >= 8GB, Power Supply >= 400W, Storage > 0TB.

Cross-field: RTX 4090 needs >= 850W PSU, and Liquid Cooling needs >= 600W PSU.

Part E - Clean Code Principles Applied

Small Functions: Configuration steps are split into short methods with clear duties.

Descriptive Naming: Used enableLiquidCooling() instead of passing setLiquidCooling(true).

Command-Query Separation: Builder methods modify internal values and return this for chaining.

Part F - Design Decision

Decision: Validation is placed inside Builder.build() right before creating the GamingPC object.

Alternative: Validating inside the GamingPC constructor.

Reasoning: This keeps validation logic inside the Builder and guarantees that the GamingPC instance is always valid and immutable.

Part G - UML Roles

Product: GamingPC

Builder: GamingPC.Builder

Director: PCDirector

Value Object: Warranty

Client: Main