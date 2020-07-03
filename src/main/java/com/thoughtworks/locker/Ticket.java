package com.thoughtworks.locker;

import java.util.UUID;

public class Ticket {
    private final String ticket;

    public Ticket() {
        this.ticket = UUID.randomUUID().toString();
    }

    public String getTicket() {
        return ticket;
    }

    @Override
    public int hashCode() {
        return ticket.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Ticket)) {
            return false;
        }
        return ((Ticket) obj).getTicket().equals(this.getTicket());
    }
}
