package GrowerFarmFieldAPI.Services;

import GrowerFarmFieldAPI.DTO.GrowerVO;
import GrowerFarmFieldAPI.Models.Grower;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import javax.ws.rs.core.Response;
import java.util.Collection;

public interface IGrowerService {
    public abstract CollectionModel<EntityModel<Grower>> getGrowers();
    public abstract EntityModel<Grower> getGrower(Long id);
    public abstract EntityModel<Grower> createGrower(GrowerVO grower);
    public abstract void deleteGrower(Long id);
}
