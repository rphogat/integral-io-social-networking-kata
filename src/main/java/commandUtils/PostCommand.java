package commandUtils;

import domain.User;
import ui.UserInterface;

import java.util.List;

public class PostCommand extends TwitterCommand implements Command {

    private String message;

    public PostCommand(String userName, String message){
        super(userName);
        this.message = message;
    }

    @Override
    public String process(UserInterface ui, List<User> users) {
        User user = super.getUser(users);
        user.getWall().addPost(user, message);
        return ui.post();
    }
}
