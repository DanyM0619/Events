import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private apiUrl = 'http://localhost:8080/events';

  constructor(
    private http: HttpClient
  ) { }

  getEvents(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

}
