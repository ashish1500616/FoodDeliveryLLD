# Food Delivery System

This repository contains the source code for a Food Delivery System. The system is designed to facilitate the process of
ordering and delivering food from various restaurants to customers. It is a simplified version focusing on the essential
components and functionality.

## Table of Contents

- [Introduction](#introduction)
- [Classes](#classes)
- [Use Cases](#use-cases)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Food Delivery System is a software application that allows customers to browse and order food from multiple
restaurants. It also provides functionality for delivery executives to accept and deliver orders to customers. The
system simplifies the process of food delivery by automating various tasks and ensuring efficient management of orders.

## Classes

The repository consists of several classes that represent different entities and functionalities of the Food Delivery
System. Here are the main classes and their descriptions:

1. **User**: Represents a user of the system, which can be either a customer or a delivery executive. It contains
   information such as the user's ID, name, contact details, and address.

2. **Restaurant**: Represents a restaurant that offers food delivery service. It includes information like the
   restaurant's ID, name, contact details, and address. The `Restaurant` class also has methods for managing menus and
   processing orders.

3. **Menu**: Represents the menu of a restaurant. It contains a list of `MenuItem` objects, which represent individual
   food items along with their names, descriptions, and prices.

4. **MenuItem**: Represents a single item on a restaurant's menu. It includes properties like the item's ID, name,
   description, and price.

5. **Order**: Represents a customer's order. It contains information such as the order ID, customer details, delivery
   details, order status, and the list of items ordered.

6. **DeliveryExecutive**: Represents a delivery executive who delivers orders to customers. It includes information like
   the executive's ID, name, contact details, and current location.

   **..Updates as we progress**

## Use Cases

This Food Delivery System repository can be used for various purposes, including:

1. **Learning and Understanding**: The codebase provides an opportunity to study the implementation of a simplified food
   delivery system. By examining the classes and their interactions, developers can gain a better understanding of how
   different components fit together to create such a system.

2. **Prototype Development**: The repository can serve as a starting point for building a more advanced food delivery
   application. Developers can leverage the existing classes and extend them to add additional features based on
   specific requirements.

3. **Education and Training**: The codebase can be utilized in educational settings or coding bootcamps to teach
   concepts related to object-oriented programming, system design, and software architecture. Students can analyze,
   modify, and enhance the code to reinforce their learning.

4. **Codebase Reference**: The repository can be used as a reference or inspiration when developing a similar food
   delivery system from scratch. Developers can refer to the existing implementation to understand best practices,
   design patterns, and common functionalities.

## Contributing

If you wish to contribute to this repository or have any suggestions, please follow the standard guidelines for
open-source contributions. Fork the repository, make your changes, and submit a
