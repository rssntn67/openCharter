package OpenCharterDB.controller;

import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import OpenCharterDB.assembler.NaveModelAssembler;
import org.springframework.hateoas.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import OpenCharterDB.model.Nave;
import OpenCharterDB.repository.NaveRepository;


@RestController
public class NaveController {

    private final NaveRepository repository;
    private final NaveModelAssembler assembler;
    NaveController(NaveRepository repository, NaveModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }


    @GetMapping("/navi")
    public CollectionModel<EntityModel<Nave>> all() {

        List<EntityModel<Nave>> navi = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(navi, linkTo(methodOn(NaveController.class).all()).withSelfRel());
    }

    @GetMapping("/navi/{id}")
    public EntityModel<Nave> one(@PathVariable Long id) {

        Nave nave = repository.findById(id) //
                .orElseThrow(() -> new NaveNotFoundException(id));

    return assembler.toModel(nave);
    }

    @PutMapping("/navi/{id}")
    ResponseEntity<?> replaceNave(@RequestBody Nave newNave, @PathVariable Long id) {

        Nave updatedNave = repository.findById(id) //
                .map(nave -> {
                    nave.setName(newNave.getName());
                    nave.setTipo(newNave.getTipo());
                    nave.setNazione(newNave.getNazione());
                    nave.setPortorif(newNave.getPortorif());
                    nave.setArmatore(newNave.getArmatore());
                    nave.setProprietario(newNave.getProprietario());
                    nave.setLung(newNave.getLung());
                    nave.setLarg(newNave.getLarg());
                    nave.setAlt(newNave.getAlt());
                    return repository.save(nave);
                })
                .orElseGet(() -> {
                    newNave.setId(id);
                    return repository.save(newNave);
                });

        EntityModel<Nave> entityModel = assembler.toModel(updatedNave);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }


    @PostMapping("/navi")
    ResponseEntity<?> newNave(@RequestBody Nave newNave) {

        EntityModel<Nave> entityModel = assembler.toModel(repository.save(newNave));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/navi/{id}")
    ResponseEntity<?> deleteNave(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}