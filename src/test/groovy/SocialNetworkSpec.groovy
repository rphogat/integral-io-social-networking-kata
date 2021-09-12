

import ui.UserInterface
import spock.lang.Specification

class SocialNetworkSpec extends Specification {

    SocialNetwork socialnetwork

    def setup() {
        socialnetwork = new SocialNetwork(new UserInterface())
        socialnetwork.processCommand("Ritu -> Hello there")
        Thread.sleep(500)
        socialnetwork.processCommand("Sakshi -> This is Sakshi")
        Thread.sleep(500)
        socialnetwork.processCommand("Ritu -> I am happy")
        Thread.sleep(500)
    }

    def "SocialNetwork should post"(){
        expect:
        socialnetwork.processCommand("Ritu -> Hello there") == "Message has been posted!\n"
        socialnetwork.processCommand("Ritu -< Hello there") == ""
    }

    def "SocialNetwork should read"(){
        expect:
        socialnetwork.processCommand("Ritu").split("\n")[0].contains("I am happy")
        socialnetwork.processCommand("Ritu").split("\n")[1].contains("Hello there")
        socialnetwork.processCommand("Sakshi").split("\n")[0].contains("This is Sakshi")
    }

    def "SocialNetwork should print result"(){
        expect:
        socialnetwork.printCommandResult("Ritu -> Hello there")
        !socialnetwork.printCommandResult("")
    }
}
