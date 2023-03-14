package OpenCharterDB.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import OpenCharterDB.controller.NaveController;
import OpenCharterDB.model.Nave;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class NaveModelAssembler implements RepresentationModelAssembler<Nave, EntityModel<Nave>> {

    @Override
    public EntityModel<Nave> toModel(Nave nave) {

        return EntityModel.of(nave,
                linkTo(methodOn(NaveController.class).one(nave.getId())).withSelfRel(),
                linkTo(methodOn(NaveController.class).all()).withRel("navi"));
    }
}