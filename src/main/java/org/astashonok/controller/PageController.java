package org.astashonok.controller;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.astashonok.exception.RoomNotFoundException;
import org.astashonok.model.Room;
import org.astashonok.service.CountryService;
import org.astashonok.service.GeoLocationService;
import org.astashonok.service.IpAddressService;
import org.astashonok.service.RoomService;
import org.astashonok.validator.RoomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private RoomValidator roomValidator;
    @Autowired
    private GeoLocationService geoLocationService;
    @Autowired
    private IpAddressService ipAddressService;

    @GetMapping(value = {"/", "/home", "/index"})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("title", "Home");
        modelAndView.addObject("homeClicked", true);
        return modelAndView;
    }

    @GetMapping(value = "/show/all/rooms")
    public ModelAndView showAllRooms() {
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("title", "All Rooms");
        modelAndView.addObject("allRoomsClicked", true);
        modelAndView.addObject("listRooms", roomService.getAll());
        return modelAndView;
    }

    @GetMapping(value = "/show/{id}/room")
    public ModelAndView showSingleProduct(@PathVariable int id, HttpServletRequest request, boolean filterPrivateAddresses)
            throws IOException, GeoIp2Exception, RoomNotFoundException {
        ModelAndView modelAndView = new ModelAndView("page");

        Room room = roomService.getById(id);
        String ipAddress = ipAddressService.determineIp(request, filterPrivateAddresses);
//        String ipAddress = "178.120.47.154";
        System.out.println(ipAddress);
        if (ipAddress != null && !ipAddress.isEmpty()) {
            String countryName = geoLocationService.findCountryNameByIp(ipAddress);
            if (countryName != null && !countryName.isEmpty()) {
                if (countryName.equals(room.getCountryName())) {
                    modelAndView.addObject("title", "Single Room");
                    modelAndView.addObject("singleRoomClicked", true);
                    modelAndView.addObject("room", room);
                } else {
                    modelAndView.addObject("title", "Room Unavailable");
                    modelAndView.addObject("errorTitle", "The room is not available for you!");
                    modelAndView.addObject("errorDescription", "you do not have access to "
                            + "this room because you are from another country!");
                    modelAndView.addObject("errorThrown", true);
                }
            }
        }
        return modelAndView;
    }

    @GetMapping(value = "/registration")
    public ModelAndView registerGet(@RequestParam(name = "operation", required = false) String operation) {
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("title", "Registration");
        modelAndView.addObject("registrationClicked", true);
        Room nRoom = new Room();
        modelAndView.addObject("room", nRoom);
        if (operation != null && operation.equals("room")) {
            modelAndView.addObject("message", "Room Submitted Successfully!");
        }
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public String registerPost(@ModelAttribute("room") Room mRoom, BindingResult result, Model model) {
        roomValidator.validate(mRoom, result);
        if (result.hasErrors()) {
            model.addAttribute("registrationClicked", true);
            model.addAttribute("title", "Registration");
            model.addAttribute("message", "Validation fails for Room Submission!");
            return "page";
        }
        roomService.addRoom(mRoom);
        return "redirect:/registration?operation=room";
    }

    @PostMapping(value = "/light/{id}/activation")
    public void activeLight(@PathVariable long id) throws RoomNotFoundException {
        Room room = roomService.getById(id);
        boolean isActive = room.isLightBulbStatus();
        room.setLightBulbStatus(!isActive);
        roomService.editRoom(room);
    }

    @GetMapping(value = "/subscribe/room/{id}")
    @ResponseBody
    public String subscribeRoom(@PathVariable long id) throws RoomNotFoundException {
        return String.valueOf(roomService.getById(id).isLightBulbStatus());
    }

    @ModelAttribute("countryNames")
    public List<String> getCategories() {
        return countryService.getAll();
    }
}
