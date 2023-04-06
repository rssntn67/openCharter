package OpenCharterDB.controller;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import OpenCharterDB.model.Info;
import OpenCharterDB.repository.InfoRepository;
import org.springframework.hateoas.*;
import OpenCharterDB.assembler.InfoModelAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InfoController {

    private final InfoRepository repository;
    private final InfoModelAssembler assembler;
    InfoController(InfoRepository repository, InfoModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/info")
    public CollectionModel<EntityModel<Info>> all() {

        List<EntityModel<Info>> infos = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(infos, linkTo(methodOn(InfoController.class).all()).withSelfRel());
    }

    @GetMapping("/info/{id}")
    public EntityModel<Info> one(@PathVariable Long id) {

        Info info = repository.findById(id) //
                .orElseThrow(() -> new InfoNotFoundException(id));

        return assembler.toModel(info);
    }


    @PutMapping("/info/{id}")
    ResponseEntity<?> replaceInfo(@RequestBody Info newInfo, @PathVariable Long id) {

        Info updatedInfo = repository.findById(id) //
                .map(info -> {
                    info.setLat(newInfo.getLat());
                    info.setLon(newInfo.getLon());
                    info.setData(newInfo.getData());
                    return repository.save(info);
                })
                .orElseGet(() -> {
                    newInfo.setId(id);
                    return repository.save(newInfo);
                });

        EntityModel<Info> entityModel = assembler.toModel(updatedInfo);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @PostMapping("/info")
    ResponseEntity<?> newInfo(@RequestBody Info newInfo) {

        EntityModel<Info> entityModel = assembler.toModel(repository.save(newInfo));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/info/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}