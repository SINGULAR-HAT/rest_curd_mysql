package com.Mysql.crud.controller;

import com.Mysql.crud.model.Users;
import com.Mysql.crud.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    public UsersService service;

    @PostMapping
    public Users createOne(@RequestBody Users user) {
        return service.insert(user);
    }

    @PostMapping("/many")
    public List<Users> createMany(@RequestBody List<Users> users) {
        return service.insertMany(users);
    }

    @GetMapping("/seeAll")
    public List<Users> seeAll() {
        return service.getAll();
    }

    @GetMapping("/see/{id}")
    public Optional<Users> findOne(@PathVariable long id) {
        return service.getById(id);
    }

    @PutMapping("/update/{id}")
    public Users update(@PathVariable long id, @RequestBody Users user){
        return service.update(id,user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        return service.delete(id);
    }

}
