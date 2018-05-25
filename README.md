# prj-jse-bookstore
Desktop application to automate a book store.

## How it works?
It's very simple to use, these are some instructions:

**_Menu:_** 
   - At the menu you can access the options for:

**1. Products:**
   - _Book:_ you can add, update and delete a book or list all the books.
   - _DVD:_ you can add, update and delete a dvd or list all the dvds.
   - _Hardware:_ select between a Cellphone or a Laptop, so you can add, update and delete a hardware or list all the hardwares in the category.
   - _Magazine:_ you can add, update and delete a magazine or list all the magazines.
   - _Return:_ always use to return to the previous menu.

**2. Individuals:**
   - _Customer:_ you can add, update and delete a customer or list all the customers.
   - _Employee:_ you can add, update and delete an employee or list all the employees.
   - _Return:_ always use to return to the previous menu.

**3. Order:**
   - Use to add an order at the book store.

**4. Reports:**
   - _Individuals:_ here you can generate some reports related to customers and employees.
      - _Customers Filtered and Ordered by Name:_ insert a name or letter to search a customer, and generate a report filtered and ordered by customer name.
      - _Employees Filtered by Name and Ordered by Highest Salary:_ insert a name or letter to search an employee, and generate a report filtered and ordered by the highest salary.
      - _Employee Salary with Commission by Month:_ search an employee by its ID and the date that you want to generate your salary with commission report. 
   - _Stock - Products to Replace:_ lists all products that don't have more stock.
   - _Sales:_ here you can generate some reports related to sales.
      - _Total Orders in a Month:_ insert the date that you want to know which orders were generated in this period and the amount.
      - _Total Sales per Seller:_ insert the employee ID that you want to know how many sales he has made so far.
      - _List an Order by ID:_ insert the order ID that you want to check the order amount, date and items sold.
   - _Return:_ always use to return to the previous menu.

**0. Exit:**
   - Use to get out from the application.

## Which Database?
To connect in this application, use the MySQL database.

1. Take the script and insert it into MySQL;
2. Create a database with th name: `bookstore_db`;
3. Take the dump at the sql folder and import to MySQL;
4. Access the application folder, than target folder and execute the comand: `java -jar prj-jse-bookstore-1.0-SNAPSHOT.jar`;
5. The application will start.

## How to contact me:
**Fatima Vasquez Varanda**
- :email: fvv.vasquez@gmail.com
- :phone: (11) 95273-2773
- :information_source: [LinkedIn](https://www.linkedin.com/in/fatimavasquez/)

## Thanks :thumbsup:
