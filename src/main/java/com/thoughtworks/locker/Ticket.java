package com.thoughtworks.locker;

import java.util.UUID;

public class Ticket {
    private final String ticket;
    private final SizeEnum size;

    public Ticket(final SizeEnum size) {
        this.ticket = UUID.randomUUID().toString();
        this.size = size;
    }

    public String getTicket() {
        return ticket;
    }

    public SizeEnum getSize() {
        return size;
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
