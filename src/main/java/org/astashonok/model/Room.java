package org.astashonok.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "rooms")
public class Room implements Serializable {

    private static final long serialVersionUID = 3079127178607551445L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "room_name")
    private String roomName;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "light_bulb_status")
    private boolean lightBulbStatus;

    public Room() {
    }

    public Room(long id, String roomName, String countryName, boolean lightBulbStatus) {
        this.id = id;
        this.roomName = roomName;
        this.countryName = countryName;
        this.lightBulbStatus = lightBulbStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public boolean isLightBulbStatus() {
        return lightBulbStatus;
    }

    public void setLightBulbStatus(boolean lightBulbStatus) {
        this.lightBulbStatus = lightBulbStatus;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + roomName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", lightBulbStatus=" + lightBulbStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return lightBulbStatus == room.lightBulbStatus &&
                Objects.equals(roomName, room.roomName) &&
                Objects.equals(countryName, room.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomName, countryName, lightBulbStatus);
    }
}
