package commandUtils

import spock.lang.Specification

class CommandUtilsSpec extends Specification {

    def "Should recognize post command"(){
        expect:
        command instanceof PostCommand

        where:
        command = CommandUtils.build("Ritu -> Hello there")
    }


    def "Should recognize read command"(){
        expect:
        command instanceof ReadCommand

        where:
        command = CommandUtils.build("Saket")
    }

}
