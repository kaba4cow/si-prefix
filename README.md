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

## Installation

Clone and build:

```bash
git clone https://github.com/kaba4cow/si-prefix.git
cd si-prefix
mvn clean install
```

Add to your `pom.xml`:

```
xml<dependency>
    <groupId>com.kaba4cow</groupId>
    <artifactId>si-prefix</artifactId>
    <version>1.0.0</version>
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
String normalized2 = SIPrefix.normalizeValue("0.000072");  // Returns "72μ"

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

### Parsing SI Prefixes

```java
// Extract the prefix from a string
SIPrefix prefix = SIPrefix.parsePrefix("42G");  // Returns SIPrefix.GIGA
```

## License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.