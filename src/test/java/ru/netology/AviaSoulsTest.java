package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    TicketTimeComparator comparator = new TicketTimeComparator();
    AviaSouls avia = new AviaSouls();
    Ticket ticket1 = new Ticket("Petrozavodsk", "Moscow", 25400, 21, 23);
    Ticket ticket2 = new Ticket("Saint Petersburg", "Petrozavodsk", 22300, 19, 20);
    Ticket ticket3 = new Ticket("Petrozavodsk", "Saint Petersburg", 22300, 21, 22);
    Ticket ticket4 = new Ticket("Moscow", "Petrozavodsk", 26400, 13, 15);
    Ticket ticket5 = new Ticket("Tumen", "Moscow", 42300, 3, 8);
    Ticket ticket6 = new Ticket("Tumen", "Moscow", 28300, 6, 12);
    Ticket ticket7 = new Ticket("Tumen", "Moscow", 32300, 4, 8);
    Ticket ticket8 = new Ticket("Tumen", "Moscow", 19300, 8, 12);

    @BeforeEach
    public void setup() {
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);
        avia.add(ticket7);
        avia.add(ticket8);

    }

    @Test
    public void shouldSearch() {
        Ticket[] expected = {ticket2};

        Assertions.assertArrayEquals(expected, avia.search("Saint Petersburg", "Petrozavodsk"));
    }

    @Test
    public void shouldNotSearch() {
        Ticket[] expected = new Ticket[0];

        Assertions.assertArrayEquals(expected, avia.search("Vladivostok", "Tumen"));
    }

    @Test
    public void shouldSearchAndSort() {
        Ticket[] expected = {ticket8, ticket6, ticket7, ticket5};

        Assertions.assertArrayEquals(expected, avia.search("Tumen", "Moscow"));
    }

    @Test
    public void shouldCompareFirstBigger() {
        int expected = 1;
        Assertions.assertEquals(expected, ticket1.compareTo(ticket2));
    }

    @Test
    public void shouldCompareSecondBigger() {
        int expected = -1;
        Assertions.assertEquals(expected, ticket2.compareTo(ticket1));
    }

    @Test
    public void shouldCompareEquals() {
        int expected = 0;
        Assertions.assertEquals(expected, ticket2.compareTo(ticket3));
    }

    @Test
    public void shouldComparateFirstBigger() {
        int expected = 1;
        Assertions.assertEquals(expected, comparator.compare(ticket1, ticket2));
    }

    @Test
    public void shouldComparateSecondBigger() {
        int expected = -1;
        Assertions.assertEquals(expected, comparator.compare(ticket2, ticket1));
    }

    @Test
    public void shouldComparateEquals() {
        int expected = 0;
        Assertions.assertEquals(expected, comparator.compare(ticket2, ticket3));
    }

    @Test
    public void shouldSearchWithComparator() {
        Ticket[] expected = {ticket2};

        Assertions.assertArrayEquals(expected, avia.searchAndSortBy("Saint Petersburg", "Petrozavodsk", comparator));
    }

    @Test
    public void shouldNotSearchWithComparator() {
        Ticket[] expected = new Ticket[0];

        Assertions.assertArrayEquals(expected, avia.searchAndSortBy("Vladivostok", "Tumen", comparator));
    }

    @Test
    public void shouldSearchAndSortWithComparator() {
        Ticket[] expected = {ticket8, ticket7, ticket5, ticket6};

        Assertions.assertArrayEquals(expected, avia.searchAndSortBy("Tumen", "Moscow", comparator));
    }
}
