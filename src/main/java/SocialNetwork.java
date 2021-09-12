import commandUtils.Command;
import commandUtils.CommandUtils;
import domain.User;
import ui.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

    private List<User> users;
    private UserInterface ui;

    public SocialNetwork(UserInterface ui){
        this.ui = ui;
        this.users = new ArrayList<>();
    }

    public String processCommand(String consoleCommand) {
        Command command = CommandUtils.build(consoleCommand);
        return command.process(ui, users);
    }

    public Boolean printCommandResult(String commandResult){
        if(!commandResult.isEmpty()){
            ui.print(commandResult);
            return true;
        }
        return false;
    }
}
