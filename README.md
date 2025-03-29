# Java Date Class Implementation

## Project Overview
This Java project implements a robust `Date` class to manage calendar dates with advanced functionalities, including validation, date arithmetic, and chronological sorting. The class adheres to real-world calendar rules, including leap year calculations and month/day boundaries.

### Key Features
1. **Date Validation**  
   - Checks validity of day-month-year combinations.
   - Handles leap years (e.g., February 29, 2024 is valid; February 29, 2025 is not).
   - Supports months with 28–31 days.

2. **Date Operations**  
   - **Update Dates**: Safely modify day/month/year with automatic validity checks.
   - **Day of the Week**: Calculate using Zeller's Congruence algorithm (e.g., "Wednesday" for January 1, 2025).
   - **Date Difference**: Compute days between two dates using Julian day numbers for accuracy.

3. **Sorting**  
   - Implements `Comparable<Date>` to enable natural chronological ordering.
   - Sort dates by year → month → day (e.g., `Collections.sort()`).

4. **Formatting**  
   - Print dates in human-readable format (e.g., "January 1, 2025").

---

## Compilation and Execution

### Prerequisites
- Java Development Kit (JDK) 
- Git (optional, for cloning the repository).
  
