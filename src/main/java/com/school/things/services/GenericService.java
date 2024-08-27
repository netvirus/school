package com.school.things.services;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public abstract class GenericService<T, ID> {

    private final JpaRepository<T, ID> repository;

    protected GenericService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public Optional<T> getById(ID id) {
        return repository.findById(id);
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public T update(ID id, T updatedEntity) {
        return repository.findById(id)
                .map(entity -> {
                    copyProperties(entity, updatedEntity);
                    return repository.save(entity);
                })
                .orElseThrow(() -> new RuntimeException("Entity not found"));
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }

    protected abstract void copyProperties(T existingEntity, T updatedEntity);
}
