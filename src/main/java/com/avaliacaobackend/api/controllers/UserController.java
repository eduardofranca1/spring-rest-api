package com.avaliacaobackend.api.controllers;

import com.avaliacaobackend.api.dto.PasswordDTO;
import com.avaliacaobackend.api.dto.UserDTO;
import com.avaliacaobackend.api.dto.UserResponseDTO;
import com.avaliacaobackend.api.mapper.UserMapper;
import com.avaliacaobackend.domain.model.User;
import com.avaliacaobackend.domain.repositories.UserRepository;
import com.avaliacaobackend.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{userId}")
    public UserResponseDTO getById(@PathVariable Long userId) {
        return UserMapper.toResponseDTO(userService.getById(userId));
    }

    @GetMapping
    public List<UserResponseDTO> getAll() {
        return UserMapper.toCollectionDTO(this.userRepository.findAll());
    }

    @GetMapping("/enable")
    public List<UserResponseDTO> getAllEnable() {
        return UserMapper.toCollectionDTO(this.userRepository.findAllByDeleted(false));
    }

    @GetMapping("/disabled")
    public List<UserResponseDTO> getAllDisabled() { return UserMapper.toCollectionDTO(this.userRepository.findAllByDeleted(true)); }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO create(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.create(userDTO.transformToObject());
        return UserResponseDTO.toResponseDTO(user);
    }

    @PutMapping("/changePassword/{userId}")
    public ResponseEntity<Boolean> changePassword(@RequestBody PasswordDTO passwordDTO, @PathVariable Long userId) {

        return userService.changePassword(passwordDTO, userId) ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();

    }

    @DeleteMapping("{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long userId) {
        userService.softDelete(userId);
    }

}
