package com.example.blueprint.rest;

import com.example.blueprint.logic.FooService;
import com.example.blueprint.repository.Foo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Get all Foo`s")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the foo",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Foo.class)) }),
            @ApiResponse(responseCode = "404", description = "Not found any Foo",
                    content = @Content) })
    @GetMapping
    public List<Foo> findAll() {
        return fooService.findAll();
    }

    @Operation(summary = "Get Foo by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the foo",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Foo.class)) }),
            @ApiResponse(responseCode = "404", description = "Foo not found",
                    content = @Content) })
    @GetMapping(value = "/{id}")
    public Optional<Foo> findById(@PathVariable("id") String id) {
        return fooService.findById(id);
    }

    @Operation(summary = "Create Foo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Foo was created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Foo.class)) }),
            @ApiResponse(responseCode = "400", description = "Wrong name of Foo",
                    content = @Content) })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Foo create(@RequestParam String name) {
        return fooService.create(name);
    }

    @Operation(summary = "Update Foo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Foo was updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Foo.class)) }),
            @ApiResponse(responseCode = "400", description = "Wrong name of Foo",
                    content = @Content) })
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") String id, @RequestParam String name) {
        fooService.update(id, name);
    }

    @Operation(summary = "Delete Foo by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Foo was deleted",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Foo.class)) }),
            @ApiResponse(responseCode = "404", description = "Not found Foo",
                    content = @Content) })
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        fooService.delete(id);
    }
}
