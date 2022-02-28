package com.aht.employeemanagement.model.user;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "aht_contract_emp")
public class ContractEmp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_emp_id")
    private int id;

    @Column(name = "contract_emp_start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "contract_emp_end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "contract_emp_status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public Contract getContract() {
        return contract;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "ContractEmp{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", contract=" + contract +
                ", employee=" + employee +
                '}';
    }
}
