package GrowerFarmFieldAPI.Controllers;

import GrowerFarmFieldAPI.DTO.GrowerVO;
import GrowerFarmFieldAPI.Models.Grower;
import GrowerFarmFieldAPI.Repository.GrowerRepository;
import GrowerFarmFieldAPI.Services.GrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class GrowerController {

    private static final Logger log = LoggerFactory.getLogger(GrowerController.class);

    @Autowired
    GrowerService growerService;

    @Autowired
    GrowerRepository repo;

    @GetMapping("/Grower")
    public CollectionModel<EntityModel<Grower>> growers() {
        var collectionModel = growerService.getGrowers();

        return CollectionModel.of(collectionModel,
                linkTo(methodOn(GrowerController.class).growers()).withSelfRel());
    }

    @GetMapping("/Grower/{id}")
    public ResponseEntity<?> grower(@PathVariable("id") Long id) {
        var entityModel = growerService.getGrower(id);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @PostMapping("/Grower")
    public ResponseEntity<?> createGrower(@RequestBody GrowerVO grower) {
        var entityModel = growerService.createGrower(grower);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("Grower/{id}")
    public ResponseEntity<?> deleteGrower(@PathVariable Long id) {
        growerService.deleteGrower(id);

        return ResponseEntity.noContent().build();
    }
}
