package GrowerFarmFieldAPI.Repository;

import GrowerFarmFieldAPI.Models.Grower;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface GrowerRepository extends JpaRepository<Grower, Long> {}
