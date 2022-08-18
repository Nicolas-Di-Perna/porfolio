import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Proyecto } from 'src/model/proyecto';


@Injectable({
    providedIn: 'root'
  })

  export class SProyectoService {
    proyecURL = 'http://localhost:8080/proyecto/'
  
    constructor(private httpClient: HttpClient) { }
    public lista(): Observable<Proyecto[]> {
      return this.httpClient.get<Proyecto[]>(this.proyecURL + 'lista');
    }
    public detail(id: number): Observable<Proyecto> {
      return this.httpClient.get<Proyecto>(this.proyecURL + `detail/${id}`);
    }
  
    public save(proyecto: Proyecto): Observable<any>{
      return this.httpClient.post<any>(this.proyecURL + `create`, proyecto);
    }
  
    public update(id: number, proyecto: Proyecto): Observable<any> {
      return this.httpClient.put<any>(this.proyecURL + `update/${id}`, proyecto);
    }
  
    public delete(id: number): Observable<any>{
      return this.httpClient.delete<any>(this.proyecURL + `delete/${id}`);
    }
  }

