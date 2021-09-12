import ui.UserInterface;

import java.util.Scanner;

public class Main {

    public static void main (String[] args){
        UserInterface ui = new UserInterface();
        SocialNetwork socialNetwork = new SocialNetwork(ui);
        Boolean commandProcessedOK;

        do {
            ui.prompt();
            String consoleCommand = new Scanner(System.in).nextLine();
            String commandResult = socialNetwork.processCommand(consoleCommand);
            commandProcessedOK = socialNetwork.printCommandResult(commandResult);
        } while (commandProcessedOK);
        ui.exit();
    }
}
