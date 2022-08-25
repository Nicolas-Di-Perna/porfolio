import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Estudio } from 'src/model/estudio';


@Injectable({
    providedIn: 'root'
  })
  export class SEstudioService {
   // estuURL = 'http://localhost:8080/estu/';
    estuURL = 'https://backporfolioap.herokuapp.com/estu/';
  
    constructor(private httpClient: HttpClient) { }
    
    public lista(): Observable<Estudio[]> {
      return this.httpClient.get<Estudio[]>(this.estuURL + 'lista');
    }
    public detail(id: number): Observable<Estudio> {
      return this.httpClient.get<Estudio>(this.estuURL + `detail/${id}`);
    }
  
    public save(estudio: Estudio): Observable<any>{
      return this.httpClient.post<any>(this.estuURL + `create`, estudio);
    }
  
    public update(id: number, estudio: Estudio): Observable<any> {
      return this.httpClient.put<any>(this.estuURL + `update/${id}`, estudio);
    }
  
    public delete(id: number): Observable<any>{
      return this.httpClient.delete<any>(this.estuURL + `delete/${id}`);
    }
  }