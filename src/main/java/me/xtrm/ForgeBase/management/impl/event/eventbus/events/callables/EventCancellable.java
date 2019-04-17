package me.xtrm.ForgeBase.management.impl.event.eventbus.events.callables;

import me.xtrm.ForgeBase.management.impl.event.eventbus.events.Cancellable;
import me.xtrm.ForgeBase.management.impl.event.eventbus.events.Event;

/**
 * Abstract example implementation of the Cancellable interface.
 *
 * @author DarkMagician6
 * @since August 27, 2013
 */
public abstract class EventCancellable implements Event, Cancellable {

    private boolean cancelled;

    protected EventCancellable() {
    }

    /**
     * @see com.darkmagician6.eventapi.events.Cancellable.isCancelled
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * @see com.darkmagician6.eventapi.events.Cancellable.setCancelled
     */
    @Override
    public void setCancelled(boolean state) {
        cancelled = state;
    }

}
