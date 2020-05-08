package org.astashonok.service;

import org.astashonok.exception.RoomNotFoundException;
import org.astashonok.model.Room;

import java.util.List;

public interface RoomService {
    Room addRoom(Room room);
    void delete (long id);
    Room getById(long id) throws RoomNotFoundException;
    Room editRoom(Room room);
    List<Room> getAll();
}
