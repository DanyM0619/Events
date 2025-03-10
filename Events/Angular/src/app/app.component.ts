
import { Component, OnInit } from '@angular/core';
import { AppService } from './Service/app.service';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AgregarComponent } from './agregar/agregar.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  events?: any[];

  constructor(private appService: AppService, private router: Router) {}

  navigateToForm() {
    this.router.navigate(['/agregar']);  // Navega a la ruta del formulario
  }

  ngOnInit(): void {
    this.appService.getEvents().subscribe((data) => {
      this.events = data;
      console.table(this.events); // Aquí se muestra la respuesta en formato tabla
    });
  }
}
