import fileinput


def menuDisplay():
    print('  ===============================')
    print("   = Barnyard Fruit Inventory =")
    print('  ===============================')
    print("")
    print(" PLEASE ENTER THE NUMBER THAT YOU \n"
          "       WOULD LIKE TO DO")
    print("")
    print('(1) Add New Item to Inventory')
    print('(2) Remove Item from Inventory')
    print('(3) Update Inventory')
    print('(4) View Inventory Report')
    print('(5) Menu')
    print('(6) Exit')
    print("")
    CHOICE = int(input("Enter One Of The Presented Numbers above: "))
    print("")
    menuSelection(CHOICE)


def menuSelection(CHOICE):
    if CHOICE == 1:
        addInventory()
    elif CHOICE == 2:
        removeInventory()
    elif CHOICE == 3:
        updateInventory()
    elif CHOICE == 4:
        printInventory()
    elif CHOICE == 5:
        menuDisplay()
    elif CHOICE == 6:
        exitnia()
    else:
        print("You have chosen a wrong input please see the \n"
              "options that are available")
        menuDisplay()


def addInventory():
    InventoryFile = open('Inventory.txt', 'a')
    print("Adding Inventory")
    print("================")
    item_description = input("Enter the name of the item: ").lower()
    item_quantity = input("Enter the quantity of the item: ")
    InventoryFile.write(item_description + '\n')
    InventoryFile.write(item_quantity + '\n')
    InventoryFile.close()
    CHOICE = int(input('Enter 5 to continue and 6 to exit... '))
    if CHOICE == 5:
        menuDisplay()
    elif CHOICE == 6:
        exitnia()
    else:
        print("You have chosen a wrong input please see the \n"
              "options that are available")
        menuDisplay()


def removeInventory():
    print("Removing Inventory")
    print("==================")
    InventoryFile = open('Inventory.txt', 'r')
    item_description = InventoryFile.readline()
    print('Current Inventory')
    print('-----------------')
    while item_description != '':
        item_quantity = InventoryFile.readline()
        item_description = item_description.rstrip('\n')
        item_quantity = item_quantity.rstrip('\n')
        print('Item:     ', item_description)
        print('Quantity: ', item_quantity)
        print('----------')
        item_description = InventoryFile.readline()
    InventoryFile.close()

    item_description = input("Enter the item name to remove from inventory: ")

    file = fileinput.input('Inventory.txt', inplace=True)

    for line in file:
        if item_description in line:
            for iteym in range(1):
                next(file, None)
        else:
            print(line.strip('\n'), end='\n')

    CHOICE = int(input('Enter 5 to continue and 6 to exit... '))
    if CHOICE == 5:
        menuDisplay()
    elif CHOICE == 6:
        exitnia()
    else:
        print("You have chosen a wrong input please see the \n"
              "options that are available")
        menuDisplay()


def updateInventory():
    InventoryFile = open('Inventory.txt', 'r')
    item_description = InventoryFile.readline()
    print('Current Inventory')
    print('-----------------')
    while item_description != '':
        item_quantity = InventoryFile.readline()
        item_description = item_description.rstrip('\n')
        item_quantity = item_quantity.rstrip('\n')
        print('Item:     ', item_description)
        print('Quantity: ', item_quantity)
        print('----------')
        item_description = InventoryFile.readline()
    InventoryFile.close()


    print("Use The Exact Item name")
    print("")
    print("Updating Inventory")
    print("==================")
    item_description = input('Enter the item to update: ')
    item_quantity = int(input("Enter the updated quantity. Use the (-)sign to decrease the value. "))

    with open('Inventory.txt', 'r') as fd:
        filedata = fd.readlines()

    replace = ""
    count = 0
    fd = open('Inventory.txt', 'r')
    file = fd.read().split('\n')
    for itemz, line in enumerate(file):
        if item_description in line:
            for dataz in file[itemz + 1:itemz + 2]:
                value = int(dataz)
                change = value + item_quantity
                replace = dataz.replace(dataz, str(change))
            count = itemz + 1
    fd.close()

    filedata[count] = replace + '\n'

    with open('Inventory.txt', 'w') as fayl:
        for line in filedata:
            fayl.write(line)

    CHOICE = int(input('Enter 5 to continue and 6 to exit... '))
    if CHOICE == 5:
        menuDisplay()
    elif CHOICE == 6:
        exitnia()
    else:
        print("You have chosen a wrong input please see the \n"
              "options that are available")
        menuDisplay()


def printInventory():
    InventoryFile = open('Inventory.txt', 'r')
    item_description = InventoryFile.readline()
    print('Current Inventory')
    print('-----------------')
    while item_description != '':
        item_quantity = InventoryFile.readline()
        item_description = item_description.rstrip('\n')
        item_quantity = item_quantity.rstrip('\n')
        print('Item:     ', item_description)
        print('Quantity: ', item_quantity)
        print('----------')
        item_description = InventoryFile.readline()
    InventoryFile.close()

    CHOICE = int(input('Enter 5 to continue and 6 to exit... '))
    if CHOICE == 5:
        menuDisplay()
    elif CHOICE == 6:
        exitnia()
    else:
        print("You have chosen a wrong input please see the \n"
              "options that are available")
        menuDisplay()


def exitnia():
    from datetime import date
    print("")
    print("===================================================")
    print(' YOU ARE DONE UPDATING AND CHECKING THE INVENTORY')
    print("===================================================")
    print('FORMAT : LASTNAME, FIRSTNAME MIDDLE INITIALS')
    imoname = input("   ENTER EMPLOYEE NAME :  ")
    today = date.today()
    print("   DATE OF LOGIN AND CHECKING:", today)
    print("===================================================")
    print("   BARNYARD'S FRUIT INVENTORY HAS BEEN UPDATED\n          "
          "AND CHANGES HAD BEEN MADE")
    InventoryFile = open('Inventory.txt', 'r')
    item_description = InventoryFile.readline()
    print("")
    print('UPDATED INVENTORY')
    print('----------------------------------------------------')
    print('EMPLOYEE CURRENTLY IN CHARGE: ' + imoname )
    print('****************************************************')
    while item_description != '':
        item_quantity = InventoryFile.readline()
        item_description = item_description.rstrip('\n')
        item_quantity = item_quantity.rstrip('\n')
        print('Item:',item_description +'        Quantity:',item_quantity)


        item_description = InventoryFile.readline()
    InventoryFile.close()
    print("****************************************************")
    print('----------------------------------------------------')
    exit()


menuDisplay()