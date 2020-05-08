package org.astashonok.service.impl;

import org.astashonok.exception.RoomNotFoundException;
import org.astashonok.model.Room;
import org.astashonok.repository.RoomRepository;
import org.astashonok.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room addRoom(Room room) {
        return roomRepository.saveAndFlush(room);
    }

    @Override
    public void delete(long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public Room getById(long id) throws RoomNotFoundException {
        return roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
    }

    @Override
    public Room editRoom(Room room) {
        return roomRepository.saveAndFlush(room);
    }

    @Override
    public List<Room> getAll() {
        return roomRepository.findAll();
    }
}
