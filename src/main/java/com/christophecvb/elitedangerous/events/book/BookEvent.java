package com.christophecvb.elitedangerous.events.book;

import com.christophecvb.elitedangerous.events.Event;

public abstract class BookEvent extends Event {
    public Long cost;
    public String destinationSystem;
    public String destinationLocation;
}
