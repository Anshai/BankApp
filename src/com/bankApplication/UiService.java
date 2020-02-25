package com.bankApplication;

public class UiService {
    // Main app welcome message and menu
    public void mainWelcomeMessage() {
        System.out.println("\n===== Bank Application =====\n");
    }

    // Main app menu
    public void mainAppMenu() {
        System.out.println("- SELECT ANY OPTION BY TYPING IN THE ID");
        System.out.println("1 - Bank ADMIN");
        System.out.println("2 - Client side");
        System.out.println("\n");
    }

    // ========== BANK ADMIN ========== //

    // Bank Manager Menu
    public void bankManagerMenu() {
        System.out.println("\n");
        System.out.println("1 - Show Available Banks");
        System.out.println("2 - Create Bank");
        System.out.println("3 - Select Bank");
        System.out.println("4 - Delete Bank");
        System.out.println("0 - Back to main menu");
        System.out.println("\n");
    }

    // Print One banks info
    public void printBankInfo(Bank bank) {
        System.out.println("----------");
        System.out.println("[NAME]: " + bank.getName() + "\n");
    }

    // Welcome message bank
    public void welcomeMsgBank(Bank bank) {
        System.out.println("===== " + bank.getName() + " ADMIN =====\n");
    }

    // Individual Bank menu
    public void individualBankMenu() {
        System.out.println("1 - Show Bank Information (SOLD)");
        System.out.println("2 - Show the list of clients");
        System.out.println("3 - Show Client information");
        System.out.println("0 - back to main menu");
    }

    // Individual Bank info
    public void bankInfo(Bank bank) {
        System.out.println("----- " + bank.getName() + " INFO -----");
        System.out.println("[SOLD]:\t" + bank.getSold());
    }


    // ========== CLIENT SIDE ========== //

    // Client Side Main Menu
    public void clientSideMainMenu() {
        System.out.println("\n");
        System.out.println("1 - I am already a client");
        System.out.println("2 - I want to be a client");
        System.out.println("3 - Back to main menu\n");
    }


    // ========== SHARED ========== //

    // Wrong input message
    public void wrongInput() {
        System.out.println("[Wrong input] Try again...");
    }

    // App Exiting message
    public void appExitMessage(){
        System.out.println("\nThe application will exit now...\n");
    }

    // ==================== DEVELOPMENT MESSAGE ====================== //
    public void underDevelopment() {
        System.out.println("This is under development...");
    }

}
