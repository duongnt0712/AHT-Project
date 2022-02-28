package com.aht.employeemanagement.model.user;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "aht_contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private int id;

    @Column(name = "contract_code", length = 10)
    private String code;

    @Column(name = "contract_type")
    private int type;

    @OneToMany(mappedBy = "contract", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ContractEmp> contractEmps;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Set<ContractEmp> getContractEmps() {
        return contractEmps;
    }

    public void setContractEmps(Set<ContractEmp> contractEmps) {
        this.contractEmps = contractEmps;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", type=" + type +
                ", contractEmps=" + contractEmps +
                '}';
    }
}
