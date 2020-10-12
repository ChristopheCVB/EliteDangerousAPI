package com.github.ChristopheCVB.EliteDangerous.events;

public class MusicEvent extends Event {
    public String musicTrack;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onMusicEventTriggered((MusicEvent) event);
        }

        void onMusicEventTriggered(MusicEvent musicEvent);
    }
}
