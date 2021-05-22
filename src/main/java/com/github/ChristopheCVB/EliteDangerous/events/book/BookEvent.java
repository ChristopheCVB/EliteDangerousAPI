package com.github.ChristopheCVB.EliteDangerous.events.book;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public abstract class BookEvent extends Event {
    public Long cost;
    public String destinationSystem;
    public String destinationLocation;
}
