package GrowerFarmFieldAPI.Controllers;

import GrowerFarmFieldAPI.Exceptions.GrowerNotFoundException;
import GrowerFarmFieldAPI.Models.Grower;
import GrowerFarmFieldAPI.Repository.GrowerRepository;
import GrowerFarmFieldAPI.Services.GrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@RestController
public class GrowerController {

    private static final Logger log = LoggerFactory.getLogger(GrowerController.class);

    @Autowired
    GrowerService growerService;

    @GetMapping("/Grower")
    public ResponseEntity<?> growers() {
        var entityModel = growerService.getGrowers();

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @GetMapping("/Grower/{id}")
    public ResponseEntity<?> grower(@PathVariable("id") Long id) {
        var entityModel = growerService.getGrower(id);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @PostMapping("/Grower")
    public ResponseEntity<?> createGrower(@RequestBody Grower grower) {
        System.out.println("**** Hit Growers POST ****");
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
