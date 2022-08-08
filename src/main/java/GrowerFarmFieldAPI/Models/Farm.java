package GrowerFarmFieldAPI.Models;

import javax.persistence.*;

@Entity
@Table(name = "farm")
public class Farm {

    @Id
    @Column(name = "farm_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long farmId;

    @Column(name = "name")
    private String name;

    @Column(name = "third_party")
    private boolean thirdParty;

    public long getFarmId() {
        return farmId;
    }

    public void setFarmId(long farmId) {
        this.farmId = farmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(boolean thirdParty) {
        this.thirdParty = thirdParty;
    }
}
