package com.bankApplication;

public class BankManager {
    // Dependencies
    UiService uiService;
    UserInputService userInputService;
    BankService bankService;


    // VARS
    String level = "BANK MANAGER";
    int userInput;


    public BankManager() {
        // Initializing dependencies
        this.uiService = new UiService();
        this.userInputService = new UserInputService();
        this.bankService = new BankService();
    }

    public void manageBanks() {
        do{
            this.userInput = this.userInputService.menuInput(level);

            switch (this.userInput) {

                case 1 :
                    // Print the list of the banks
                    bankService.printBanks();
                    break;
                case 2 :
                    bankService.addBank();
                    break;
                case 3 :
                    bankService.manageBank();
                    break;
                case 4 :
                    bankService.deleteBank();
                    break;
                case 0 :
                    System.out.println("Back to main menu..\n");
                    break;
                default :
                    uiService.wrongInput();
                    break;
            }

        }while(this.userInput != 0);
    }
}
