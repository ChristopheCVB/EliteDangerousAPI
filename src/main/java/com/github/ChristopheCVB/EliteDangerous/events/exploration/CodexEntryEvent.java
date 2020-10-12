package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CodexEntryEvent extends Event {
    public String name;
    public String subCategory;
    public String subCategoryLocalised;
    public String category;
    public String categoryLocalised;
    public String region;
    public String system;
    public Integer entryID;
    public Long systemAddress;
    public Boolean isNewEntry;
    public Boolean newTraitsDiscovered;
    public String[] traits;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCodexEntryEventTriggered((CodexEntryEvent) event);
        }

        void onCodexEntryEventTriggered(CodexEntryEvent codexEntryEvent);
    }
}
