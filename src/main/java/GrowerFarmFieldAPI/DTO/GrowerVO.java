package GrowerFarmFieldAPI.DTO;

import GrowerFarmFieldAPI.Models.Farm;

import java.util.List;

public class GrowerVO {

    private long id;

    private String name;

    private List<Farm> farms;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Farm> getFarms() {
        return farms;
    }

    public void setFarms(List<Farm> farms) {
        this.farms = farms;
    }
}
