package com.school.things.services;

import com.school.things.entities.*;
import com.school.things.repositories.BooksRepository;
import com.school.things.repositories.ShirtRepository;
import com.school.things.repositories.ShortsRepository;
import com.school.things.repositories.PantsRepository;
import com.school.things.repositories.SkirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThingService {

    @Autowired
    private ShirtRepository shirtRepository;

    @Autowired
    private ShortsRepository shortsRepository;

    @Autowired
    private PantsRepository pantsRepository;

    @Autowired
    private SkirtRepository skirtRepository;

    @Autowired
    private BooksRepository booksRepository;

    // Методы для работы с Shirt

    public List<Shirt> getAllShirts() {
        return shirtRepository.findAll();
    }

    public Optional<Shirt> getShirtById(Long id) {
        return shirtRepository.findById(id);
    }

    public Shirt saveShirt(Shirt shirt) {
        return shirtRepository.save(shirt);
    }

    public Shirt updateShirt(Long id, Shirt updatedShirt) {
        return shirtRepository.findById(id)
                .map(shirt -> {
                    shirt.setName(updatedShirt.getName());
                    shirt.setColor(updatedShirt.getColor());
                    shirt.setSize(updatedShirt.getSize());
                    return shirtRepository.save(shirt);
                })
                .orElseThrow(() -> new RuntimeException("Shirt not found"));
    }

    public void deleteShirt(Long id) {
        shirtRepository.deleteById(id);
    }

    // Методы для работы с Shorts

    public List<Shorts> getAllShorts() {
        return shortsRepository.findAll();
    }

    public Optional<Shorts> getShortsById(Long id) {
        return shortsRepository.findById(id);
    }

    public Shorts saveShorts(Shorts shorts) {
        return shortsRepository.save(shorts);
    }

    public Shorts updateShorts(Long id, Shorts updatedShorts) {
        return shortsRepository.findById(id)
                .map(shorts -> {
                    shorts.setName(updatedShorts.getName());
                    shorts.setColor(updatedShorts.getColor());
                    shorts.setSize(updatedShorts.getSize());
                    return shortsRepository.save(shorts);
                })
                .orElseThrow(() -> new RuntimeException("Shorts not found"));
    }

    public void deleteShorts(Long id) {
        shortsRepository.deleteById(id);
    }

    // Методы для работы с Pants

    public List<Pants> getAllPants() {
        return pantsRepository.findAll();
    }

    public Optional<Pants> getPantsById(Long id) {
        return pantsRepository.findById(id);
    }

    public Pants savePants(Pants pants) {
        return pantsRepository.save(pants);
    }

    public Pants updatePants(Long id, Pants updatedPants) {
        return pantsRepository.findById(id)
                .map(pants -> {
                    pants.setName(updatedPants.getName());
                    pants.setColor(updatedPants.getColor());
                    pants.setSize(updatedPants.getSize());
                    return pantsRepository.save(pants);
                })
                .orElseThrow(() -> new RuntimeException("Pants not found"));
    }

    public void deletePants(Long id) {
        pantsRepository.deleteById(id);
    }

    // Методы для работы с Skirt

    public List<Skirt> getAllSkirts() {
        return skirtRepository.findAll();
    }

    public Optional<Skirt> getSkirtById(Long id) {
        return skirtRepository.findById(id);
    }

    public Skirt saveSkirt(Skirt skirt) {
        return skirtRepository.save(skirt);
    }

    public Skirt updateSkirt(Long id, Skirt updatedSkirt) {
        return skirtRepository.findById(id)
                .map(skirt -> {
                    skirt.setName(updatedSkirt.getName());
                    skirt.setColor(updatedSkirt.getColor());
                    skirt.setSize(updatedSkirt.getSize());
                    return skirtRepository.save(skirt);
                })
                .orElseThrow(() -> new RuntimeException("Skirt not found"));
    }

    public void deleteSkirt(Long id) {
        skirtRepository.deleteById(id);
    }

    // Методы для работы с Books

    public List<Books> getAllBooks() {
        return booksRepository.findAll();
    }

    public Optional<Books> getBookById(Long id) {
        return booksRepository.findById(id);
    }

    public Books saveBook(Books book) {
        return booksRepository.save(book);
    }

    public Books updateBook(Long id, Books updatedBook) {
        return booksRepository.findById(id)
                .map(book -> {
                    book.setName(updatedBook.getName());
                    book.setColor(updatedBook.getColor());
                    book.setUnit(updatedBook.getUnit());
                    book.setGrade(updatedBook.getGrade());
                    return booksRepository.save(book);
                })
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public void deleteBook(Long id) {
        booksRepository.deleteById(id);
    }
}
