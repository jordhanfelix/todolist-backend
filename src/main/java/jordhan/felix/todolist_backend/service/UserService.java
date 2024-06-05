package jordhan.felix.todolist_backend.service;

import jordhan.felix.todolist_backend.controller.Dto.InputUserDto;
import jordhan.felix.todolist_backend.entity.User;
import jordhan.felix.todolist_backend.exception.BadRequestException;
import jordhan.felix.todolist_backend.exception.NotFoundExeption;
import jordhan.felix.todolist_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(InputUserDto userDto){

        return userRepository.save(userDto.toUser());
    }

    public List<User> list(){

        return userRepository.findAll();
    }

    public User find(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundExeption(id));
    }

    public User update(Long id, InputUserDto userDto){
        return userRepository.findById(id).map(existingUser -> {

            existingUser.setName(userDto.name());
            existingUser.setEmail(userDto.email());

            return userRepository.save(existingUser);
        }).orElseThrow(() -> new BadRequestException("Usuário %d não existe! ".formatted(id)));
    }

    public void delete(Long id){
       try {
           userRepository.deleteById(id);
       }catch (Exception e){
         throw  new BadRequestException("Usuário %d não existe! ".formatted(id));
       }
    }
}
