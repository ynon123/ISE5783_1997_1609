package geometries;

import primitives.*;

import java.util.List;
import java.util.Objects;


/**
 * The Intersectable interface defines an objects that can be intersected by a ray in 3D space.
 */
public abstract class Intersectable {
    public static class GeoPoint {
        public Geometry geometry;
        public Point point;
        public GeoPoint(Geometry geometry, Point point) {
            this.geometry = geometry;
            this.point = point;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GeoPoint geoPoint = (GeoPoint) o;
            return Objects.equals(geometry, geoPoint.geometry) && Objects.equals(point, geoPoint.point);
        }
        @Override
        public String toString() {
            return "GeoPoint{" +
                    "geometry=" + geometry +
                    ", point=" + point +
                    '}';
        }
    }

//    public final List<GeoPoint> findGeoIntersections(Ray ray) {
//        return findGeoIntersections(ray, Double.POSITIVE_INFINITY);
//    }
    public final List<GeoPoint> findGeoIntersections(Ray ray) {
        return findGeoIntersections(ray, Double.POSITIVE_INFINITY);
    }
    protected abstract List<GeoPoint>
    findGeoIntersectionsHelper(Ray ray, double maxDistance);



    public List<GeoPoint> findGeoIntersections(Ray ray, double maxDistance) {
        return findGeoIntersectionsHelper(ray, maxDistance);
    }
    public List<Point> findIntersections(Ray ray) {
        var geoList = findGeoIntersections(ray);
        return geoList == null ? null : geoList.stream().map(gp -> gp.point).toList();
    }
//    protected abstract List<GeoPoint> findGeoIntersectionsHelper(Ray ray);
}