package com.bankApplication;

public class Bank {
    // Dependencies
    UiService uiService;
    UserInputService userInputService;

    // VARS
    private Bank next;
    private String name;
    private int sold;

    public Bank(String name) {
        // Initializing dependencies
        this.uiService = new UiService();
        this.userInputService = new UserInputService();

        // Init Vars
        this.name = name;
        this.next = null;
        this.sold = 0;
    }

    // Check if next bank exists
    public boolean hasNext() {
        return this.next != null;
    }

    public String getName() {
        return name;
    }

    public Bank getNext() {
        return next;
    }

    public int getSold() {
        return sold;
    }

    public void setNext(Bank next) {
        this.next = next;
    }

    // ========== CLIENT METHODS ========== //
    // Print client list
    public void printClientList() {
        uiService.underDevelopment();
    }

    // Print individual client info
    public void clientInfo() {
        uiService.underDevelopment();
    }
}
