package ui

import domain.Post
import domain.User
import spock.lang.Specification

class UserInterfaceSpec extends Specification {

    UserInterface ui
    List<Post> postToPrint

    def setup() {
        ui = new UserInterface()
        postToPrint = new ArrayList<>()
        postToPrint.add(new Post(new User("Ritu"), "Hello there"))
    }

    def "User Interface should print wall posts"(){
        expect:
        ui.postToPrint(postToPrint,true).split("\n")[0].contains("Ritu -> Hello there")
    }

    def "User Interface should print read posts"(){
        expect:
        ui.postToPrint(postToPrint,false).split("\n")[0].contains("Hello there")
    }

    def "User Interface should print prompt"(){
        expect:
        ui.prompt()
    }

    def "User Interface should print exit"(){
        expect:
        ui.exit()
    }
}
