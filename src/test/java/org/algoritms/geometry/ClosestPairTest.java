package org.algoritms.geometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClosestPairTest {

    @Test
    void testClosestPair() {
        ClosestPair.Point[] points = {
                new ClosestPair.Point(2, 3),
                new ClosestPair.Point(12, 30),
                new ClosestPair.Point(40, 50),
                new ClosestPair.Point(5, 1),
                new ClosestPair.Point(12, 10),
                new ClosestPair.Point(3, 4)
        };

        ClosestPair cp = new ClosestPair();
        double result = cp.closest(points);

        assertEquals(Math.sqrt(2), result, 1e-6);
        System.out.println("Closest distance: " + result);
    }
}