package com.bramar.spring.internaleventhandler.filter;

import com.bramar.spring.internaleventhandler.model.AbstractDomainEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DomainEventLogger {

    Logger log = LoggerFactory.getLogger(DomainEventLogger.class);

    @EventListener
    public void logEvent(AbstractDomainEvent event) {
        log.info("Receive event of type: {}", event.getClass().getSimpleName() + " at " + event.getFormattedTimestamp());
    }
}
