package com.bramar.spring.internaleventhandler.service;

public abstract class GenericEventListener<T> {

    public void handleEvent(T event) {
        try {
            if (getEventType().isInstance(event)) {
                System.out.println("Handling event: " + event.getClass());
                processEvent(getEventType().cast(event));
            }
        } catch (Exception e) {
            System.err.println("Error in handling event: " + e.getMessage());
        }
    }

    public abstract void processEvent(T event);

    protected abstract Class<T> getEventType();

}
