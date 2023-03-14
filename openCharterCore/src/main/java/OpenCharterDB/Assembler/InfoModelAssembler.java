package OpenCharterDB.Assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import OpenCharterDB.Infocontroller.InfoController;
import OpenCharterDB.model.Info;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class InfoModelAssembler implements RepresentationModelAssembler<Info, EntityModel<Info>> {

    @Override
    public EntityModel<Info> toModel(Info info) {

        return EntityModel.of(info,
                WebMvcLinkBuilder.linkTo(methodOn(InfoController.class).one(info.getId())).withSelfRel(),
                linkTo(methodOn(InfoController.class).all()).withRel("info"));
    }
}