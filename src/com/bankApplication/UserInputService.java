package com.bankApplication;

import java.util.Scanner;

public class UserInputService {
    Scanner scanner;
    String stringInput;

    public UserInputService() {
        this.scanner = new Scanner(System.in);
    }

    // Menu selection input
    public int menuInput(String level) {
        System.out.print("[" + level + "] OPTION: ");
        if(scanner.hasNextInt()){       // Validating int input
            return scanner.nextInt();
        } else {
            scanner.next();
            return -1;
        }
    }

    // String input
    public String nameInput(){
        this.stringInput = scanner.nextLine();
        return new String(this.stringInput);
    }

}
