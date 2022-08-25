import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Social } from 'src/model/social.model';


@Injectable({
  providedIn: 'root'
})
export class SSocialService {
  //socialURL = 'http://localhost:8080/social/'
  socialURL = 'https://backporfolioap.herokuapp.com/social/'

  constructor(private httpClient: HttpClient) { }
  public lista(): Observable<Social[]> {
    return this.httpClient.get<Social[]>(this.socialURL + 'lista');
  }
  public detail(id: number): Observable<Social> {
    return this.httpClient.get<Social>(this.socialURL + `detail/${id}`);
  }

  public save(social: Social): Observable<any>{
    return this.httpClient.post<any>(this.socialURL + `create`, social);
  }

  public update(id: number, social: Social): Observable<any> {
    return this.httpClient.put<any>(this.socialURL + `update/${id}`, social);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.socialURL + `delete/${id}`);
  }
}