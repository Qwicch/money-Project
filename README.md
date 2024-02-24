# Money Project

Money is a Java class that represents money as a combination of a currency and an amount. It supports addition, subtraction, multiplication, and division operations with other Money objects or numeric values. It also implements the Comparable interface to allow comparison and sorting of Money objects.

## Features

- A constructor that takes a currency code and an amount as parameters, and creates a Money object with the specified values.
- A getter method that returns the currency code of the Money object.
- A getter method that returns the amount of the Money object.
- An add method that takes another Money object or a numeric value as a parameter, and returns a new Money object with the sum of the amounts and the same currency as the original object.
- A subtract method that takes another Money object or a numeric value as a parameter, and returns a new Money object with the difference of the amounts and the same currency as the original object.
- A multiply method that takes a numeric value as a parameter, and returns a new Money object with the product of the amount and the value and the same currency as the original object.
- A divide method that takes a numeric value as a parameter, and returns a new Money object with the quotient of the amount and the value and the same currency as the original object.
- A compareTo method that takes another Money object as a parameter, and returns an integer that indicates the order of the two objects based on their amounts and currencies.
- A toString method that returns a string representation of the Money object in the format "currency amount".

## Installation

To use this class, you need to have Java installed on your computer. You can clone this repository or download the ZIP file and open the Money.java file in your preferred IDE or text editor. Alternatively, you can compile and run the class from the command line using the following commands:

<!-- start:code block -->
# Compile the class
javac Money.java

# Run the class
java Money
<!-- end:code block -->

## Usage

To use this class, you need to create a Money object with a currency code and an amount. You can then perform arithmetic operations with other Money objects or numeric values, and compare and sort Money objects. Here are some examples of how to use the class:

<!-- start:code block -->
// Create a Money object with USD currency and 100 amount
Money m1 = new Money("USD", 100);

// Create another Money object with EUR currency and 50 amount
Money m2 = new Money("EUR", 50);

// Add the two Money objects and print the result
Money m3 = m1.add(m2);
System.out.println(m3); // USD 150

// Subtract 20 from the first Money object and print the result
Money m4 = m1.subtract(20);
System.out.println(m4); // USD 80

// Multiply the second Money object by 2 and print the result
Money m5 = m2.multiply(2);
System.out.println(m5); // EUR 100

// Divide the first Money object by 4 and print the result
Money m6 = m1.divide(4);
System.out.println(m6); // USD 25

// Compare the first and second Money objects and print the result
int result = m1.compareTo(m2);
System.out.println(result); // 1

// Create an array of Money objects and sort them
Money[] array = {m1, m2, m3, m4, m5, m6};
Arrays.sort(array);

// Print the sorted array
for (Money m : array) {
  System.out.println(m);
}
// EUR 50
// USD 25
// USD 80
// EUR 100
// USD 100
// USD 150
<!-- end:code block -->

## Changelog

- Version 1.0 (February 2024): Initial release of the class.

## License and Author Info

This project is licensed under the MIT License. For more information, see the LICENSE file in this repository.

This project was created by qwicch, a web developer and a dog lover. You can contact me at ilmire.kireev@gmail.com.
