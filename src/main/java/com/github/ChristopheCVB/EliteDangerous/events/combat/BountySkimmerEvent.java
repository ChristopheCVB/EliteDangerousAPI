package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class BountySkimmerEvent extends BountyEvent {
    public String faction;
    public Long reward;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onBountySkimmerEventTriggered((BountySkimmerEvent) event);
        }

        void onBountySkimmerEventTriggered(BountySkimmerEvent bountySkimmerEvent);
    }
}
