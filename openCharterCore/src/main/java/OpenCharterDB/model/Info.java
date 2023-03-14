package OpenCharterDB.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Info {

    @Id
    @GeneratedValue()
    private Long id;


    private float lat;
    private float lon;

    private long idnave;


    Info() {
    }

    public Info(float lat, float lon, long idnave) {
        this.lat = lat;
        this.lon = lon;
        this.idnave= idnave;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public long getIdnave() {
        return idnave;
    }

    public void setIdnave(long idnave) {
        this.idnave = idnave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Info info)) return false;
        return Float.compare(info.lat, lat) == 0 && Float.compare(info.lon, lon) == 0 && idnave == info.idnave && id.equals(info.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lat, lon, idnave);
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", lat=" + lat +
                ", lon=" + lon +
                ", idnave=" + idnave +
                '}';
    }
}