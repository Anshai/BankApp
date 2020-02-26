package com.bankApplication;

public class BankService {
    // Dependencies
    UiService uiService;
    UserInputService userInputService;
    private Bank bankList;

    public BankService() {
        // Initializing dependencies
        this.uiService = new UiService();
        this.userInputService = new UserInputService();

        // Init Vars
        this.bankList = null;
    }


    // Check if any bank is created
    public boolean isAnyBankCreated(){
        return this.bankList != null;
    }

    // Print banks list
    public void printBanks() {
        if(this.isAnyBankCreated()) {
            Bank current = this.bankList;
            while(current != null) {
                this.uiService.printBankInfo(current);
                current = current.getNext();
            }
        } else {
            System.out.println("[NO BANKS FOUND]\nNo banks created yet...");
        }
    }

    // Create Bank
    public Bank createBank() {
        System.out.print("[BANK NAME]: ");
        String name = userInputService.nameInput();
        Bank bank = new Bank(name);
        return bank;
    }

    // Add Bank to list
    public void addBank() {
        Bank newBank = createBank();
        if(this.isAnyBankCreated()) {
            Bank current = this.bankList;
            while(current.hasNext()){
                current = current.getNext();
            }
            current.setNext(newBank);
        } else {
            this.bankList = newBank;
        }
        System.out.println("Bank successfully created!");
        System.out.println("[NAME]: " + newBank.getName());
    }

    // Select and manage one bank
    public void manageBank() {
        System.out.print("[BANK NAME]: ");
        String bankName = this.userInputService.nameInput();
        boolean found = false;
        Bank current = this.bankList;
        Bank selectedBank = new Bank("selected");

        // Check if is any bank created
        if(this.isAnyBankCreated()){
            //Check if it is the first one
            if(current.getName().equals(bankName)){
                selectedBank = current;
                found = true;
            }
            // Check the others
            while(!found && current.hasNext()) {
                current = current.getNext();
                if(current.getName().equals(bankName)) {
                    selectedBank = current;
                    found = true;
                }
            }

            if(found) {
                System.out.println("Bank Succesfully Found!!\n");
                this.uiService.welcomeMsgBank(selectedBank);
                this.uiService.individualBankMenu();
                int userInput = 10;

                while(userInput != 0) {
                    userInput = userInputService.menuInput(selectedBank.getName());

                    switch (userInput) {
                        case 1 : uiService.bankInfo(selectedBank);
                            break;
                        case 2 : selectedBank.printClientList();
                            break;
                        case 3 :
                            selectedBank.clientInfo();
                            break;
                        case 0 :
                            System.out.println("Going back to main menu..");
                            uiService.bankManagerMenu();
                            break;
                        default:
                            uiService.wrongInput();
                            break;
                    }
                }
            } else {
                System.out.println("This bank doesn't exist");
            }
        } else {
            System.out.println("[NO BANKS FOUND]\nNo banks created yet...");
        }
    }

    // Delete bank
    public void deleteBank() {
        boolean deleted = false;
        String name;
        System.out.println("[NAME OF THE BANK THAT YOU WANT TO DELETE]: ");
        name = userInputService.nameInput();

        // Check if any banks exist
        if(isAnyBankCreated()) {
            Bank current = this.bankList;
            // Check if it is the first one
            if(current.getName().equals(name)){
                this.bankList = this.bankList.getNext();
                deleted = true;
            } else {
                Bank previous = current;
                while(!deleted && current.hasNext()){
                    current = current.getNext();
                    if(current.getName().equals(name)){
                        if(!current.hasNext()){
                            previous.setNext(null);
                            deleted = true;
                        } else {
                            previous.setNext(current.getNext());
                            deleted = true;
                        }
                    }
                    if(!deleted){
                        previous = current;
                    }
                }
            }
            if(deleted){
                System.out.println("Bank Succesfully deleted!!");
            } else {
                System.out.println("Wrong Name entered..");
            }
        } else {
            System.out.println("[NO BANKS FOUND]\nNo banks created yet...");
        }

    }

    // Get Banks List
    public Bank getBankList() {
        return bankList;
    }

}
