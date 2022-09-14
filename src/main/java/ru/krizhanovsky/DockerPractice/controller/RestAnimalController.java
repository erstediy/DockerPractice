package ru.krizhanovsky.DockerPractice.controller;

import org.springframework.web.bind.annotation.*;
import ru.krizhanovsky.DockerPractice.entity.Animal;
import ru.krizhanovsky.DockerPractice.service.AnimalService;

import java.util.List;

@RestController
@RequestMapping("/rest/animal")
public class RestAnimalController {

    private final AnimalService service;

    public RestAnimalController(AnimalService service) {
        this.service = service;
    }

    @GetMapping
    public List<Animal> getAllAnimals(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable Long id){
        return service.getAnimalById(id);
    }

    @PostMapping
    public String saveAnimal(@RequestBody Animal animal){
        System.out.println(animal);
        service.addAnimal(animal);
        return "Successfully save";
    }
}
