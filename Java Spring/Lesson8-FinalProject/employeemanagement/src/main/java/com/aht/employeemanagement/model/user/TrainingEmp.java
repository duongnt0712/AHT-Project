package com.aht.employeemanagement.model.user;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "aht_training_emp")
public class TrainingEmp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_emp_id")
    private int id;

    @Column(name = "training_emp_start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "training_emp_end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "training_emp_status")
    private int status;

    @Column(name = "training_emp_result", length = 4000)
    private String result;

    @ManyToOne
    @JoinColumn(name = "training_id")
    private Training training;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Training getTraining() {
        return training;
    }

    @Override
    public String toString() {
        return "TrainingEmp{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", result='" + result + '\'' +
                ", training=" + training +
                ", employee=" + employee +
                '}';
    }
}
