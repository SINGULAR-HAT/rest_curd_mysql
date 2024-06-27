package com.Mysql.crud.service;

import com.Mysql.crud.model.Users;
import com.Mysql.crud.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    public UsersRepository repository;

    public Users insert(Users user) {
        return repository.save(user);
    }

    public List<Users> insertMany(List<Users> users) {
        return repository.saveAll(users);
    }

    public List<Users> getAll(){
        return repository.findAll();
    }

    public Optional<Users> getById(long id) {
        return repository.findById(id);
    }

    public Users update(long id, Users user) {
        Optional<Users> userOptional = repository.findById(id);
        if (userOptional.isPresent()) {
            Users users = userOptional.get();
            users.setUsername(user.getUsername());
            users.setPassword(user.getPassword());
            users.setEmail(user.getEmail());
            users.setPhone(user.getPhone());
            return repository.save(users);
        }
        return null;
    }

    public String  delete(long id) {
        Optional<Users> userOptional = repository.findById(id);
        if (userOptional.isPresent()) {
            repository.deleteById(id);
            return "Deleted User";
        }
        return "User Not Found";
    }
}
