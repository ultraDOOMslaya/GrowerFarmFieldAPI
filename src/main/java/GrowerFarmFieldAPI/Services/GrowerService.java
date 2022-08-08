package GrowerFarmFieldAPI.Services;

import GrowerFarmFieldAPI.Assemblers.GrowerModelAssembler;
import GrowerFarmFieldAPI.DTO.GrowerVO;
import GrowerFarmFieldAPI.Exceptions.GrowerNotFoundException;
import GrowerFarmFieldAPI.Models.Grower;
import GrowerFarmFieldAPI.Repository.GrowerRepository;
import org.hibernate.EntityMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GrowerService implements IGrowerService {

    @Autowired
    GrowerRepository repo;

    @Autowired
    GrowerModelAssembler assembler;

    public CollectionModel<EntityModel<Grower>> getGrowers() {


        List<EntityModel<Grower>> growers =  repo.findAll().stream()
                .map(grower -> assembler.toModel(grower))
                .collect(Collectors.toList());

        return CollectionModel.of(growers);
    }

    public EntityModel<Grower> getGrower(Long id) {
        EntityModel<Grower> grower = assembler.toModel(repo.findById(id).orElseThrow(() -> new GrowerNotFoundException(id)));

        return grower;
    }

    public EntityModel<Grower> createGrower(GrowerVO grower) {
        Grower growerEntity = new Grower();
        growerEntity.setName(grower.getName());
        growerEntity.setFarms(grower.getFarms());

        EntityModel<Grower> entityModel = assembler.toModel(repo.save(growerEntity));

        return entityModel;
    }

    public void deleteGrower(Long id) {
        repo.deleteById(id);
    }
}
