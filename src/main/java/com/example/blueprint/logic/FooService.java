package com.example.blueprint.logic;

import com.example.blueprint.repository.Foo;
import com.example.blueprint.repository.FooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FooService {

    @Autowired
    private FooRepository fooRepo;

    public List<Foo> findAll() {
        return fooRepo.findAll();
    }

    public Optional<Foo> findById(String id) {
        return fooRepo.findById(id);
    }

    public Foo create(String name) {
        Foo foo = Foo.builder().name(name).build();
        return fooRepo.save(foo);
    }

    public void update(String id, String name) {
        Foo foo = fooRepo.findById(id).get();
        foo.setName(name);
        fooRepo.save(foo);
    }

    public void delete(String id) {
        Foo foo = fooRepo.findById(id).get();
        fooRepo.delete(foo);
    }
}
