It is highly recommended to use a terminal compatible with ANSI Escape Codes

Summary:

This program is a system for managing the attendance of an event, allowing you to add people (either "paying" or "non-paying"), remove people, view the complete list, view the "non-paying" list, and calculate a cost for excess guests given a number for the party package and the cost per each excess guest.

How to use:

Upon starting the application, choose an option between numbers 1 and 5, each with its specific function.

1 - Add guests to the list:

When selecting this option, simply type as many names as you want, pressing "enter" after each name. If a guest is a "non-paying" guest (not counted in the list), just add a minus sign (-) to the name, either before, after, with or without space. To stop adding guests, type "exit" to return to the main menu.

2 - Remove guests from the list:

When selecting this option, you will need to specify which guest from the list will be removed based on their number in the list. It is recommended to use option 3 (show complete list) to identify the number of the guest to be removed before starting the removal. To cancel the removal, simply type "exit" to return to the main menu.

3 - Show complete list:

When selecting this option, the complete guest list will be displayed on the screen in a numbered format, making it easier to count the total number.

4 - Show non-paying guests list:

When selecting this option, only the "non-paying" guests (those added with "-" in the name) will be shown, and this list will also be numbered.

5 - Calculate excess guests:

When selecting this option, you will need to provide the number of guests for the party package and then specify the cost for each person exceeding the package number. In this calculation, non-paying guests are not counted towards the total number of guests. For example, if the list has 20 total guests, with 5 being non-paying, and you specify that the party package is for 15 guests, it will be considered as 0 excess guests, as the number of "paying" guests totals 15, not exceeding the package.
An example where the excess would be calculated: if the party has a total of 60 guests on the list, with only 5 non-paying, and you specify that the party package is for 50 guests, this will result in a total of 5 excess guests, as the party has 55 "paying" guests for a 50-person package. In this case, you should specify the cost for each excess guest. For instance, if we assume a cost of 50 reais per excess guest, the total amount to be paid for excess guests would be 250 reais.
At any point after selecting the option to calculate excess guests, you can type "exit" to return to the main menu.

EXIT - Exit the program:

To exit the program, simply be at the main menu and type "EXIT" in uppercase letters, then confirm with "s". If you change your mind and decide not to close the program, just type "n" during the confirmation. This option is not visible for security reasons, as once the program is closed, all data will be lost.
