package com.example.blueprint.rest;

import com.example.blueprint.logic.FooService;
import com.example.blueprint.repository.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/foo")
class FooController {

    @Autowired
    private FooService fooService;

    @GetMapping
    public List<Foo> findAll() {
        return fooService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Foo> findById(@PathVariable("id") String id) {
        return fooService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Foo create(@RequestParam String name) {
        return fooService.create(name);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") String id, @RequestParam String name) {
        fooService.update(id, name);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        fooService.delete(id);
    }
}
