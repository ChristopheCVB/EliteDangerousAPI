package com.github.ChristopheCVB.EliteDangerous.events;

public class ReceiveTextEvent extends Event {
    public String from;
    public String fromLocalised;
    public String message;
    public String messageLocalised;
    public String channel;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onReceiveTextEventTriggered((ReceiveTextEvent) event);
        }

        void onReceiveTextEventTriggered(ReceiveTextEvent receiveTextEvent);
    }
}
