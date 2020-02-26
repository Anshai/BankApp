package com.bankApplication;

public class Main {

    public static void main(String[] args) {
	    // Dependecies
        UiService uiService = new UiService();
        UserInputService userInputService = new UserInputService();
        BankManager bankManager = new BankManager();
        ClientSideManager clientSideManager = new ClientSideManager();

        // VARS
        String level = "MAIN MENU";
        int userInput;

        // Application Lifecycle
        uiService.mainWelcomeMessage();
        uiService.mainAppMenu();

        do{
            userInput = userInputService.menuInput(level);

            switch (userInput) {
                case 1 :
                    uiService.bankManagerMenu();
                    bankManager.manageBanks();
                    break;
                case 2 :
                    System.out.println("---");
                    System.out.println(bankManager.bankService.getBankList());
                    System.out.println("---");
                    uiService.clientSideMainMenu();
                    clientSideManager.manageClients();
                    break;
                case 0 :
                    uiService.appExitMessage();
                    break;
                default :
                    uiService.wrongInput();
                    break;
            }
        }while(userInput != 0);
    }
}
