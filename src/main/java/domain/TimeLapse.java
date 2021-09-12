package domain;

import time.Clock;

public class TimeLapse {

    private Clock clock;
    private Long time;

    public TimeLapse(Clock clock, Long time){
        this.clock = clock;
        this.time = time;
    }

    public Clock getClock() {
        return clock;
    }

    public Long getTime() {
        return time;
    }
}
