import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

    private baseUrl = 'https://imouto-api.herokuapp.com/employee';

    constructor(private http: HttpClient) { }

    getEmployeesList(): Observable<Employee[]> {
        return this.http.get<Employee[]>(`${this.baseUrl}`);
    }

    getEmployeeById(id: number): Observable<Employee> {
        return this.http.get<Employee>(`${this.baseUrl}/${id}`);
    }

    createEmployee(employee: Object): Observable<Object> {
        return this.http.post(`${this.baseUrl}`, employee, { responseType: 'text'});
    }

    updateEmployee(id: number, employee: Employee): Observable<Object> {
        return this.http.put(`${this.baseUrl}/${id}`, employee, { responseType: 'text'});
    }

    deleteEmployee(id: number): Observable<any> {
        return this.http.delete(`${this.baseUrl}?id=${id}`, { responseType: 'text' });
    }

}
