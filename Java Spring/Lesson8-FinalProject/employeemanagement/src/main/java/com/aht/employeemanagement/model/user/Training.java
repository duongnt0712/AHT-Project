package com.aht.employeemanagement.model.user;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "aht_training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_id")
    private int id;

    @Column(name = "training_code", length = 10)
    private String code;

    @Column(name = "training_name", length = 100)
    private String name;

    @Column(name = "training_start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "training_end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "training_status")
    private int status;

    @OneToMany(mappedBy = "training", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TrainingEmp> trainingEmps;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<TrainingEmp> getTrainingEmps() {
        return trainingEmps;
    }

    public void setTrainingEmps(Set<TrainingEmp> trainingEmps) {
        this.trainingEmps = trainingEmps;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", trainingEmps=" + trainingEmps +
                '}';
    }
}
