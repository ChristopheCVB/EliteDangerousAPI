package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class FriendsEvent extends Event {
    public static final String[] STATUS = {"Requested", "Declined", "Added", "Lost", "Offline", "Online"};

    public String status;
    public String name;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onFriendsEventTriggered((FriendsEvent) event);
        }

        void onFriendsEventTriggered(FriendsEvent friendsEvent);
    }
}
