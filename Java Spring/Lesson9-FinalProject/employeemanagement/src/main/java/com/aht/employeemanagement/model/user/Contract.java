package com.aht.employeemanagement.model.admin;

import javax.persistence.*;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private int id;

    @Column(name = "contract_code", length = 10)
    private String code;

    @Column(name = "contract_type")
    private int type;

    public Contract(int id, String code, int type) {
        this.id = id;
        this.code = code;
        this.type = type;
    }

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

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", type=" + type +
                '}';
    }
}
