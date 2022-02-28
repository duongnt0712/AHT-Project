import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../services/employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: '../create-employee/create-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

    id: number;
    employee: Employee;
  
    constructor(private route: ActivatedRoute,private router: Router,
      private employeeService: EmployeeService) { }
  
    ngOnInit() {
      this.employee = new Employee();
  
      this.id = this.route.snapshot.params['id'];
      
      this.employeeService.getEmployeeById(this.id)
        .subscribe(data => {
          console.log(data)
          this.employee = data;
        }, error => console.log(error));
    }
  
    updateEmployee() {
      this.employeeService.updateEmployee(this.id, this.employee)
        .subscribe(data => {
          this.employee = new Employee();
          this.gotoList();
        }, error => console.log(error));
    }
  
    gotoList() {
      this.router.navigate(['/employee']);
      console.log("navigated")
    }

    onSubmit() {
        this.updateEmployee();    
    }
}
