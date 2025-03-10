import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AgregarService {

  private apiUrl = 'http://localhost:8080/events';  // Dirección de tu backend

  constructor(private http: HttpClient) { }

  createEvent(event: any): Observable<any> {
    return this.http.post(this.apiUrl, event);
  }
}
