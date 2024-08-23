package com.school.things.controllers;

import com.school.things.entities.Books;
import com.school.things.entities.Shirt;
import com.school.things.entities.Shorts;
import com.school.things.entities.Pants;
import com.school.things.entities.Skirt;
import com.school.things.services.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/things")
public class ThingsController {

    @Autowired
    private ThingService thingService;

    // Endpoints для работы с Shirt

    @GetMapping("/shirts")
    public List<Shirt> getAllShirts() {
        return thingService.getAllShirts();
    }

    @GetMapping("/shirts/{id}")
    public Optional<Shirt> getShirtById(@PathVariable Long id) {
        return thingService.getShirtById(id);
    }

    @PostMapping("/shirts")
    public Shirt createShirt(@RequestBody Shirt shirt) {
        return thingService.saveShirt(shirt);
    }

    @PutMapping("/shirts/{id}")
    public Shirt updateShirt(@PathVariable Long id, @RequestBody Shirt shirt) {
        return thingService.updateShirt(id, shirt);
    }

    @DeleteMapping("/shirts/{id}")
    public void deleteShirt(@PathVariable Long id) {
        thingService.deleteShirt(id);
    }

    // Endpoints для работы с Shorts

    @GetMapping("/shorts")
    public List<Shorts> getAllShorts() {
        return thingService.getAllShorts();
    }

    @GetMapping("/shorts/{id}")
    public Optional<Shorts> getShortsById(@PathVariable Long id) {
        return thingService.getShortsById(id);
    }

    @PostMapping("/shorts")
    public Shorts createShorts(@RequestBody Shorts shorts) {
        return thingService.saveShorts(shorts);
    }

    @PutMapping("/shorts/{id}")
    public Shorts updateShorts(@PathVariable Long id, @RequestBody Shorts shorts) {
        return thingService.updateShorts(id, shorts);
    }

    @DeleteMapping("/shorts/{id}")
    public void deleteShorts(@PathVariable Long id) {
        thingService.deleteShorts(id);
    }

    // Endpoints для работы с Pants

    @GetMapping("/pants")
    public List<Pants> getAllPants() {
        return thingService.getAllPants();
    }

    @GetMapping("/pants/{id}")
    public Optional<Pants> getPantsById(@PathVariable Long id) {
        return thingService.getPantsById(id);
    }

    @PostMapping("/pants")
    public Pants createPants(@RequestBody Pants pants) {
        return thingService.savePants(pants);
    }

    @PutMapping("/pants/{id}")
    public Pants updatePants(@PathVariable Long id, @RequestBody Pants pants) {
        return thingService.updatePants(id, pants);
    }

    @DeleteMapping("/pants/{id}")
    public void deletePants(@PathVariable Long id) {
        thingService.deletePants(id);
    }

    // Endpoints для работы с Skirt

    @GetMapping("/skirts")
    public List<Skirt> getAllSkirts() {
        return thingService.getAllSkirts();
    }

    @GetMapping("/skirts/{id}")
    public Optional<Skirt> getSkirtById(@PathVariable Long id) {
        return thingService.getSkirtById(id);
    }

    @PostMapping("/skirts")
    public Skirt createSkirt(@RequestBody Skirt skirt) {
        return thingService.saveSkirt(skirt);
    }

    @PutMapping("/skirts/{id}")
    public Skirt updateSkirt(@PathVariable Long id, @RequestBody Skirt skirt) {
        return thingService.updateSkirt(id, skirt);
    }

    @DeleteMapping("/skirts/{id}")
    public void deleteSkirt(@PathVariable Long id) {
        thingService.deleteSkirt(id);
    }

    // Endpoints для работы с Books

    @GetMapping("/books")
    public List<Books> getAllBooks() {
        return thingService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Optional<Books> getBookById(@PathVariable Long id) {
        return thingService.getBookById(id);
    }

    @PostMapping("/books")
    public Books createBook(@RequestBody Books book) {
        return thingService.saveBook(book);
    }

    @PutMapping("/books/{id}")
    public Books updateBook(@PathVariable Long id, @RequestBody Books book) {
        return thingService.updateBook(id, book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        thingService.deleteBook(id);
    }
}
