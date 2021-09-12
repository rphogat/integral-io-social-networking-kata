package ui;

import domain.Post;
import domain.TimeLapse;
import time.Clock;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserInterface {

    public String postToPrint(List<Post> postsToPrint, Boolean toWall) {
        postsToPrint.sort(Comparator.comparing(Post::getDate));
        Collections.reverse(postsToPrint);
        StringBuilder posts = new StringBuilder("");
        postsToPrint.forEach(post -> createPost(toWall, posts, post));
        return posts.toString();
    }

    private void createPost(Boolean toWall, StringBuilder posts, Post post) {
        if(toWall){
            posts.append(post.getUser().getName()).append(" -> ");
        }
        posts.append(post.getMessage()).append(" ").append(printTimeLapse(Clock.lapse(post.getDate()))).append("\n");
    }

    private String printTimeLapse(TimeLapse timeLapse){
        return "(" +
                timeLapse.getTime() +
                " " +
                (timeLapse.getTime() > 1L ? timeLapse.getClock().getMagnitude().getPlural() : timeLapse.getClock().getMagnitude().getSingular()) +
                " " +
                "ago)";
    }

    public String post() {
        return "Message has been posted!\n";
    }

    public String follow(String userName, String userNameToFollow) {
        return userName + " is now following " + userNameToFollow + "\n";
    }

    public Boolean prompt(){
        System.out.print("katas-social-networking > \n");
        return true;
    }

    public Boolean print(String toPrint){
        System.out.print(toPrint);
        return true;
    }

    public Boolean exit() {
        System.out.print("Bye!\n");
        return true;
    }
}
