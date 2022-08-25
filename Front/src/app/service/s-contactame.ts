import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Contactame } from 'src/model/contactame';



@Injectable({
    providedIn: 'root'
  })
  export class SContactameService {
    //contacURL = 'http://localhost:8080/contactame/'
    contacURL = 'https://backporfolioap.herokuapp.com/contactame/'
    constructor(private httpClient: HttpClient) { }

    public lista(): Observable<Contactame[]> {
      return this.httpClient.get<Contactame[]>(this.contacURL + 'lista');
    }
    public detail(id: number): Observable<Contactame> {
      return this.httpClient.get<Contactame>(this.contacURL + `detail/${id}`);
    }
  
    public save(contactame: Contactame): Observable<any>{
      return this.httpClient.post<any>(this.contacURL + `create`, contactame);
    }
  
    public update(id: number, contactame: Contactame): Observable<any> {
      return this.httpClient.put<any>(this.contacURL + `update/${id}`, contactame);
    }
  
    public delete(id: number): Observable<any>{
      return this.httpClient.delete<any>(this.contacURL + `delete/${id}`);
    }
  }

