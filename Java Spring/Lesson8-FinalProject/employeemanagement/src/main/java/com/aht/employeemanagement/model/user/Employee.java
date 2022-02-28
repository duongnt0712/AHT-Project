package com.aht.employeemanagement.model.user;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "aht_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int id;

    @Column(name = "emp_name", length = 50)
    private String name;

    @Column(name = "emp_dob")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "emp_sex")
    private int sex;

    @Column(name = "emp_number_insurance", length = 50)
    private String numberInsurance;

    @Column(name = "emp_address", length = 200)
    private String address;

    @Column(name = "emp_phone", length = 12)
    private String phone;

    @Column(name = "emp_type")
    private int type;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TrainingEmp> trainingEmps;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ContractEmp> contractEmps;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getNumberInsurance() {
        return numberInsurance;
    }

    public void setNumberInsurance(String numberInsurance) {
        this.numberInsurance = numberInsurance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Set<TrainingEmp> getTrainingEmps() {
        return trainingEmps;
    }

    public void setTrainingEmps(Set<TrainingEmp> trainingEmps) {
        this.trainingEmps = trainingEmps;
    }

    public Set<ContractEmp> getContractEmps() {
        return contractEmps;
    }

    public void setContractEmps(Set<ContractEmp> contractEmps) {
        this.contractEmps = contractEmps;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", sex=" + sex +
                ", numberInsurance='" + numberInsurance + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type +
                ", department=" + department +
                ", contract=" + contract +
                ", trainingEmps=" + trainingEmps +
                ", contractEmps=" + contractEmps +
                '}';
    }
}
