package com.aht.employeemanagement.model.admin;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ContractEmp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_emp_id")
    private int id;

    @Column(name = "contract_emp_start_date")
    private Date startDate;

    @Column(name = "contract_emp_end_date")
    private Date endDate;

    @Column(name = "contract_emp_status")
    private int status;

    @Column(name = "contract_id")
    private int contractId;

    @Column(name = "emp_id")
    private int empId;

}
