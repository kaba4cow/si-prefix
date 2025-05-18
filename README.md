# SI Prefix Library

A **Java** library for handling SI (International System of Units) prefixes, providing utility methods for parsing, formatting, and comparing values with SI prefixes.

## Overview

The SI Prefix library simplifies working with SI unit prefixes ranging from quecto (10^-30) to quetta (10^30). It allows you to:

- Parse values with SI prefixes into numeric representations
- Format numbers with appropriate SI prefixes
- Compare string values that include different SI prefixes
- Normalize values to use the most appropriate SI prefix

## Features

- Supports all standard SI prefixes
- High precision calculations using `BigDecimal`
- Simple API for common operations
- `SIDecimal` class that extends `BigDecimal` with SI prefix functionality

## Installation

Clone and build:

```bash
git clone https://github.com/kaba4cow/si-prefix.git
cd si-prefix
mvn clean install
```

Add to your `pom.xml`:

```xml
<dependency>
    <groupId>com.kaba4cow</groupId>
    <artifactId>si-prefix</artifactId>
    <version>1.1.0</version>
</dependency>
```

Requirements: 

- **Java** version **8** or higher.

## Usage

### Basic Usage

```java
// Parse a string with an SI prefix into a BigDecimal
BigDecimal value = SIPrefix.parseValue("2.5k");  // Returns 2500

// Normalize values with appropriate SI prefixes
String normalized = SIPrefix.normalizeValue("2500");  // Returns "2.5k"
String normalized2 = SIPrefix.normalizeValue("0.000072");  // Returns "72u"

// Compare values with different prefixes
boolean equal = SIPrefix.valuesEqual("1M", "1000k");  // Returns true
int comparison = SIPrefix.compareValues("1.5G", "2000M");  // Returns -1 (less than)
```

### Working with SIPrefix Enum

```java
// Get a specific prefix
SIPrefix kilo = SIPrefix.KILO;

// Get the prefix symbol
String symbol = kilo.getPrefix();  // Returns "k"

// Get the exponent
int exponent = kilo.getExponent();  // Returns 3

// Get the multiplier
BigDecimal multiplier = kilo.getMultiplier();  // Returns 1000
```

### Using SIDecimal Class

The `SIDecimal` class extends Java's `BigDecimal` to provide all standard numeric operations while adding support for SI prefixes in string representation.

```java
// Create an SIDecimal from a string with SI prefix
SIDecimal value1 = new SIDecimal("2.5k");  // Equivalent to 2500
SIDecimal value2 = new SIDecimal("1.7M");  // Equivalent to 1700000

// Perform arithmetic operations
SIDecimal sum = value1.add(value2);        // 1702500
SIDecimal product = value1.multiply(value2); // 4250000000

// Auto-formatting with appropriate SI prefixes
System.out.println(value1);      // Outputs: "2.5k"
System.out.println(value2);      // Outputs: "1.7M" 
System.out.println(sum);         // Outputs: "1.7025M"
System.out.println(product);     // Outputs: "4.25G"

// Get the underlying scaled value and prefix
SIPrefix prefix = value1.getPrefix();              // Returns SIPrefix.KILO
BigDecimal scaledValue = value1.getScaledValue();  // Returns 2.5

// Format with specific precision
String formatted = value1.toString(2, RoundingMode.HALF_UP);  // "2.50k"
```

### Parsing SI Prefixes

```java
// Extract the prefix from a string
SIPrefix prefix = SIPrefix.parsePrefix("42G");  // Returns SIPrefix.GIGA
```

## License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.