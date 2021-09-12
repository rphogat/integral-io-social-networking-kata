package commandUtils;

import domain.Post;
import domain.User;
import ui.UserInterface;

import java.util.List;
import java.util.stream.Collectors;

public class ReadCommand extends TwitterCommand implements Command {

    public ReadCommand(String userName){
        super(userName);
    }

    @Override
    public String process(UserInterface ui, List<User> users) {
        User user = super.getUser(users);
        List<Post> postsToPrint = user.getWall().getPosts().stream().filter(post -> post.getUser().getName().equals(user.getName())).collect(Collectors.toList());
        return ui.postToPrint(postsToPrint, false);
    }
}
