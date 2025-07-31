package com.bramar.spring.internaleventhandler.model;

import lombok.Getter;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public abstract class AbstractDomainEvent {
    private final Instant timestamp = Instant.now();
    private final ZonedDateTime localTimestamp;
    private final String formattedTimestamp;

    protected AbstractDomainEvent() {
        this.localTimestamp = ZonedDateTime.ofInstant(timestamp, ZoneId.systemDefault());
        this.formattedTimestamp = localTimestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
