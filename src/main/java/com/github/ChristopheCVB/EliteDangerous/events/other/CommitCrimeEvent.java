package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CommitCrimeEvent extends Event {
    public String crimeType;
    public String faction;
    public String victim;
    public Integer bounty;
    public Integer fine;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCommitCrimeEventTriggered((CommitCrimeEvent) event);
        }

        void onCommitCrimeEventTriggered(CommitCrimeEvent commitCrimeEvent);
    }
}
