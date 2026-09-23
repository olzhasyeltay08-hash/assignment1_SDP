# Assignment 1 — Builder Pattern Report (Gaming PC Configuration)

## Part A — Original Constructor Approach & Design Issues

In the initial implementation, the `GamingPC` object was constructed using a direct, multi-argument constructor containing 10 fields (including standard types, primitives, and a custom `Warranty` value object).

### Design Issues Identified:
1. **Telescoping Constructor & Poor Readability:** With 10 parameters of similar types (e.g., several `String` and `boolean` flags), calling `new GamingPC("Intel i9", "Z790", 64, 1000, "RTX 4090", 2.0, true, true, "White", warranty)` makes the code extremely difficult to read and understand without looking up parameter definitions.
2. **High Error Prone (Argument Swapping):** Passing multiple contiguous `boolean` flags (e.g., `liquidCooling`, `rgbLighting`) or `int` parameters creates a high risk of inadvertently swapping arguments. The compiler cannot detect swapped parameters of identical types, leading to silent bugs at runtime.
3. **Lack of Validation During Construction:** Validating parameters inside a complex constructor or forcing clients to perform pre-checks before object instantiation leads to duplicate code and scattered logic across client files.

---

## Part B — Refactoring to Builder Pattern

The complex construction logic was refactored by moving fields into an inner static `Builder` class. Method chaining (Fluent API) was introduced with domain-oriented method names such as `enableLiquidCooling()` and `enableRgbLighting()`.

---

## Part C — Validation Challenge

Validation logic is strictly enforced inside the `validate()` method prior to object instantiation during the `.build()` call:

### Single-field Validation Rules:
1. **RAM Capacity Check:** Minimum required RAM is 8 GB (`ramGb >= 8`).
2. **PSU Capacity Check:** Minimum required power supply is 400 W (`powerSupplyW >= 400`).
3. **Storage Check:** Storage must be greater than 0 TB (`storageTb > 0`).

### Cross-field Validation Rules:
1. **High-End GPU Dependency:** If `gpu` contains `"RTX 4090"`, `powerSupplyW` must be at least 850 W.
2. **Liquid Cooling Dependency:** If `liquidCooling` is enabled, `powerSupplyW` must be at least 600 W.

---

## Part D — Preset Configurations (Director)

The `PCDirector` class encapsulates predefined system assembly steps to avoid duplicating Builder calls across client code:
- `constructBudgetPC()`: Entry-level gaming setup with essential specifications.
- `constructBalancedPC()`: Mid-range build targeting optimal price-to-performance ratio.
- `constructPerformancePC()`: Enthusiast-grade system with liquid cooling, high-end GPU, and extended warranty.
  *(Outputs "🍌 Performance PC built successfully!" upon creation)*[cite: 1].

---

## Part E — Clean Code (Chapter 3) Transformations

### Example 1: Avoiding Flag Arguments & Descriptive Naming
- **BEFORE:**
  ```java
  public Builder setLiquidCooling(boolean enabled) {
      this.liquidCooling = enabled;
      return this;
  }