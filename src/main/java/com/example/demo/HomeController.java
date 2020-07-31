package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.transform.Result;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    RoomRepository roomRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Room> rooms = roomRepository.findAll();
        model.addAttribute("rooms", rooms);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {

        return "redirect:/login?logout=true";
    }
    @GetMapping("/dave")
    public String adminPage(Model model){
//        model.addAttribute("", );

        return "davesPage";
    }

    @GetMapping("/details")
    public String roomDetails(Model model, @RequestParam("id") long id) {

//        long idL = Long.parseLong(id);
        Room room = roomRepository.findById(id).get();
        model.addAttribute(room);

        return "roomDetails";
    }

    @GetMapping("/dave/addRoomListing")
    public String addRoomListing(Model model) {
        model.addAttribute("room", new Room());
        model.addAttribute("submit", "Add a House!");

        return "addRoomListing";
    }
//    @ModelAttribute
    @PostMapping("/dave/processRoomListing")
    public String processRoomListing(@Valid Room room, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addRoomListing";
        }

        roomRepository.save(room);
        return "redirect:/";
    }
    @GetMapping("/dave/update/{id}")
    public String update(@PathVariable long id, Model model){
        Room room = roomRepository.findById(id).get();
        model.addAttribute("room", room);
        model.addAttribute("submit", "Update Room");
        return "addRoomListing";
    }

    @GetMapping("/dave/rentControl/{id}")
    public String rentControl(@PathVariable long id, Model model, @RequestParam("details") boolean returnToDetailPage){

        Room room = roomRepository.findById(id).get();
//       Here: I am negating whatever the isRented property holds
        room.setRented(!room.getIsRented());

        roomRepository.save(room);
        model.addAttribute("room", room);

        if (returnToDetailPage) {
            return "redirect:/details?id="+id;
        } else {
            return "redirect:/";
        }
    }


    @GetMapping("/about")
    public String about(){
        return "about";
    }

}
