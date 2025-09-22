package ru.netology;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket t1, Ticket t2) {
        int t1FlyTime = t1.getTimeTo() - t1.getTimeFrom();
        int t2FlyTime = t2.getTimeTo() - t2.getTimeFrom();
        if (t1FlyTime > t2FlyTime) {
            return 1;
        } else if (t1FlyTime < t2FlyTime) {
            return -1;
        } else {
            return 0;
        }

    }
}
