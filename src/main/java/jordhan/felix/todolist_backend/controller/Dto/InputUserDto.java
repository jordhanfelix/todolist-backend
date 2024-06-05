package jordhan.felix.todolist_backend.controller.Dto;

import jordhan.felix.todolist_backend.entity.User;

public record InputUserDto (String name, String email){

    public User toUser(){
        return new User(name, email);
    }
}
