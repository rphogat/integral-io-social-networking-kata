package commandUtils;

import domain.User;
import ui.UserInterface;

import java.util.List;

public class CommandUtils {

    private static String POST_PATTERN = "\\w+\\s+->\\s+[\\w\\s\\D]+";
    private static String READ_PATTERN = "\\w+";

    public static Command build(String command) {
        if (command.matches(POST_PATTERN)) {
            return new PostCommand(command.split(" -> ")[0], command.split(" -> ")[1]);
        } else if (command.matches(READ_PATTERN)) {
            return new ReadCommand(command);
        }
        return new BadCommand();
    }

    private static class BadCommand implements Command {
        @Override
        public String process(UserInterface ui, List<User> users) {
            return "";
        }
    }
}
