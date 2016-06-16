package systems.singularity.cinttamobi.util;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 5/30/16.
 * © 2016 Singularity Systems
 */
public class EventsTimeline {
    private static int delay = 250;
    private List<Timeline> timelineList = new ArrayList<>();

    public static void setDelay(int delay) {
        EventsTimeline.delay = delay;
    }

    public void add(EventHandler<ActionEvent> eventHandler, Integer delay) {
        timelineList.add(new Timeline(new KeyFrame(Duration.millis(delay == null ? EventsTimeline.delay : delay), eventHandler)));
        int size = timelineList.size();
        if (size > 1)
            timelineList.get(size - 2).setOnFinished(event -> timelineList.get(size - 1).play());
    }

    public void add(EventHandler<ActionEvent> eventHandler) {
        this.add(eventHandler, null);
    }

    public void play() {
        timelineList.get(0).play();
    }
}
