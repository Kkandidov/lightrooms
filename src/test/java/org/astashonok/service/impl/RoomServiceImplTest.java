package org.astashonok.service.impl;

import org.astashonok.exception.RoomNotFoundException;
import org.astashonok.model.Room;
import org.astashonok.service.RoomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = "/populatetestdb.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class RoomServiceImplTest {

    @Autowired
    private RoomService roomService;

    @Test
    public void addRoom() {
        Room expected = new Room();
        expected.setCountryName("Croatia");
        expected.setRoomName("Bad room");
        Room actual = roomService.addRoom(expected);
        assertEquals(expected, actual);
        System.out.println(expected);
        System.out.println(actual);
    }

    @Test(expected = RoomNotFoundException.class)
    public void delete() throws RoomNotFoundException {
        roomService.delete(5);
        roomService.getById(5);
    }

    @Test
    public void getById() throws RoomNotFoundException {
        Room expected = new Room(3, "funny room", "Canada",false);
        Room actual = roomService.getById(3);
        assertEquals(expected, actual);
    }

    @Test
    public void editRoom() throws RoomNotFoundException {
        Room expected = new Room(3, "GREAT ROOM", "Canada",false);
        roomService.editRoom(expected);
        Room actual = roomService.getById(3);
        assertEquals(expected, actual);
    }

    @Test
    public void getAll() {
        int expected = 5;
        int actual = roomService.getAll().size();
        assertEquals(expected, actual);
    }
}