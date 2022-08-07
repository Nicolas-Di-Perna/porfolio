import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {social} from 'src/model/social.model';
@Injectable({
  providedIn: 'root'
})
export class SocialService {
  URL = 'http://localhost:8080/social/';
 

  constructor(private httpClient: HttpClient) { }

  public getSocial(): Observable<social>{
    return this.httpClient.get<social>(this.URL + 'traer/red');
  }
}