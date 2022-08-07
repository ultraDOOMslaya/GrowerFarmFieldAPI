package GrowerFarmFieldAPI.Assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import GrowerFarmFieldAPI.Controllers.GrowerController;
import GrowerFarmFieldAPI.Models.Grower;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class GrowerModelAssembler implements RepresentationModelAssembler<Grower, EntityModel<Grower>> {

    @Override
    public EntityModel<Grower> toModel(Grower grower) {
        return EntityModel.of(grower,
                linkTo(methodOn(GrowerController.class).grower(grower.getId())).withSelfRel(),
                linkTo(methodOn(GrowerController.class).growers()).withRel("growers"));
    }
}
