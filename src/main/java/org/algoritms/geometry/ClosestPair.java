package org.algoritms.geometry;

import java.util.Arrays;

public class ClosestPair {

    public static class Point {
        public double x, y;
        public Point(double x, double y) { this.x = x; this.y = y; }
    }

    private double dist(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) +
                (p1.y - p2.y) * (p1.y - p2.y));
    }

    public double closest(Point[] points) {
        Point[] px = points.clone();
        Arrays.sort(px, (a, b) -> Double.compare(a.x, b.x));
        Point[] py = points.clone();
        Arrays.sort(py, (a, b) -> Double.compare(a.y, b.y));
        return closestUtil(px, py);
    }

    private double closestUtil(Point[] px, Point[] py) {
        int n = px.length;
        if (n <= 3) {
            double min = Double.POSITIVE_INFINITY;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    min = Math.min(min, dist(px[i], px[j]));
                }
            }
            return min;
        }

        int mid = n / 2;
        Point midPoint = px[mid];

        Point[] Qx = Arrays.copyOfRange(px, 0, mid);
        Point[] Rx = Arrays.copyOfRange(px, mid, n);

        Point[] Qy = Arrays.stream(py).filter(p -> p.x <= midPoint.x).toArray(Point[]::new);
        Point[] Ry = Arrays.stream(py).filter(p -> p.x > midPoint.x).toArray(Point[]::new);

        double dl = closestUtil(Qx, Qy);
        double dr = closestUtil(Rx, Ry);

        double d = Math.min(dl, dr);

        Point[] strip = Arrays.stream(py)
                .filter(p -> Math.abs(p.x - midPoint.x) < d)
                .toArray(Point[]::new);

        return Math.min(d, stripClosest(strip, d));
    }

    private double stripClosest(Point[] strip, double d) {
        double min = d;
        for (int i = 0; i < strip.length; i++) {
            for (int j = i + 1; j < strip.length && (strip[j].y - strip[i].y) < min; j++) {
                min = Math.min(min, dist(strip[i], strip[j]));
            }
        }
        return min;
    }
}