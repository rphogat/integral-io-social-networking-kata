package commandUtils;

import domain.User;
import ui.UserInterface;

import java.util.List;

public interface Command {

    String process(UserInterface ui, List<User> users);
}
