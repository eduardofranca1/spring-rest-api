package com.avaliacaobackend.api.controllers;

import com.avaliacaobackend.domain.model.Person;
import com.avaliacaobackend.domain.repositories.PersonRepository;
import com.avaliacaobackend.domain.services.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Tag(name = "Person endpoint")
@AllArgsConstructor
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonService personService;

    @Operation(summary = "Find all persons")
    @GetMapping
    public List<Person> getAll() { return personRepository.findAll(); }

//    @GetMapping
//    public List<PersonResponseDTO> getAll() {
//        return PersonMapper.toCollectionDTO(this.personRepository.findAll());
//    }

    @Operation(summary = "Find person by city")
    @GetMapping("/{personCity}/city")
    public List<Person> getByCity(@PathVariable String personCity) {
        return personRepository.findAllByAddressCity(personCity);
    }

//    @GetMapping("/{personCity}/city")
//    public List<PersonResponseDTO> getByCity(@PathVariable String personCity) {
//        return PersonMapper.toCollectionDTO(this.personRepository.findAllByAddressCity(personCity));
//    }

    @Operation(summary = "Find person by state")
    @GetMapping("/{personState}/state")
    public List<Person> getByState(@PathVariable String personState) {
        return personRepository.findAllByAddressState(personState);
    }

//    @GetMapping("/{personState}/state")
//    public List<PersonResponseDTO> getByState(@PathVariable String personState) {
//        return PersonMapper.toCollectionDTO(this.personRepository.findAllByAddressState(personState));
//    }

    @Operation(summary = "Find person by id")
    @GetMapping("/{personId}")
    public Person getById(@PathVariable Long personId) {
        return personService.getById(personId);
    }

//    @GetMapping("/{personId}")
//    public PersonResponseDTO getBydId(@PathVariable Long personId) {
//        return PersonMapper.toResponseDTO(personService.getById(personId));
//    }

    @Operation(summary = "Create new person")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public PersonResponseDTO create(@Valid @RequestBody PersonDTO personDTO) {
//        Person person = personService.create(personDTO.transformToObject());
//        return PersonResponseDTO.toResponseDTO(person);
//    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public PersonResponseDTO create(@RequestBody PersonRequestDTO personRequestDTO) {
//
//        Person person = PersonMapper.fromRequestDTO(personRequestDTO);
//        personService.create(person);
//        return PersonMapper.toResponseDTO(person);
//
//    }

    @Operation(summary = "Update person")
    @PutMapping("/{personId}")
    public ResponseEntity<Person> update(@PathVariable Long personId, @RequestBody Person person) {
        return ResponseEntity.ok(personService.update(personId, person));
    }

    @Operation(summary = "Upload person avatar")
    @PostMapping(value = "/{personId}/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void create(@PathVariable Long personId, @RequestParam("file") MultipartFile file) {
        personService.changeAvatar(personId, file);
    }

    @Operation(summary = "Delete person by id")
    @DeleteMapping("/{personId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long personId) { personService.delete(personId); }

}
