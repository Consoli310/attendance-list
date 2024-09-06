PROMPT = '''**********************************
1 - Add guests
2 - Remove guests
3 - View complete list
4 - View non-paying list
5 - Calculate surplus guests
'EXIT' to exit the program
**********************************
'''

def clear_console():
    print('\033[H\033[2J', end='')

def main():
    clear_console()
    while True:
        choice = 0
        while True:
            entry = input(PROMPT)
            if entry == 'EXIT':
                exit = input('Are you sure you want to exit the program? (y/n)\n')
                if exit == 'y':
                    return 0
                else:
                    clear_console()
            try:
                choice = int(entry)
            except ValueError:
                clear_console()
                print('You did not enter a number')
            if choice > 5 or choice < 1:
                clear_console()
                print('Enter a number between 1 and 5')
            else:
                break

        if choice == 1:
            clear_console()
            while True:
                clear_console()
                name = input("Enter the names followed by enter (or 'exit'):\n")
                if name != 'exit':
                    guests_list.append(name)
                else:
                    break
            no_pay_list.extend([i for i in guests_list if '-' in i])
            clear_console()

        elif choice == 2:
            while True:
                clear_console()
                choice_int = 0
                escolha = input("Enter the number of the guest to be removed (or 'exit')\n")
                if escolha == 'exit':
                    clear_console()
                    break
                try:
                    choice_int = int(escolha)
                except ValueError:
                    clear_console()
                    print('You did not enter a number')
                if choice_int > len(guests_list) or choice_int < 0:
                    clear_console()
                    print("You did not enter a valid number")
                if choice_int > 0 and choice_int <= len(guests_list):
                    guest = guests_list[choice_int - 1]
                    guests_list.pop(choice_int - 1)
                    clear_console()
                    print(guest + ' has been removed')
                    break

        elif choice == 3:
            clear_console()
            if not guests_list:
                print('The list is empty.')
                continue
            print('Complete guest list:')
            for x, i in enumerate(guests_list):
                print('--> {} - {}'.format(x + 1, i))

        elif choice == 4:
            clear_console()
            if not no_pay_list:
                print('The list is empty.')
                continue
            print('Non-paying guest list:')
            for x, i in enumerate(no_pay_list):
                print('--> {} - {}'.format(x + 1, i))

        elif choice == 5:
            clear_console()
            guest_package = 0
            entry = input("How many guests is the party package for? (or 'exit')\n")
            if entry.lower() == 'exit':
                clear_console()
                continue
            while True:
                try:
                    guest_package = int(entry)
                    break
                except ValueError:
                    clear_console()
                    print('Enter a valid value')
                    entry = input()
            while True:
                if len(guests_list) - len(no_pay_list) > guest_package:
                    clear_console()
                    entry = input("What is the cost for each excess guest? (or 'exit')\n")
                    if entry.lower() == 'exit':
                        clear_console()
                        break
                    try:
                        surplus_value = float(entry)
                        clear_console()
                        surplus_calc = (len(guests_list) - len(no_pay_list) - guest_package) * surplus_value
                        print('Total cost for excess guests: $' + str(surplus_calc))
                        break
                    except ValueError:
                        clear_console()
                        print('Enter a valid value')
                else:
                    clear_console()
                    print('There are no excess guests.')
                    break

guests_list = []
no_pay_list = []

if __name__ == '__main__':
    main()
