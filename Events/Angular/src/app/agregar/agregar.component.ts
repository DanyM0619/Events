import { Component } from '@angular/core';
import { AgregarService } from './agregar.service';

@Component({
  selector: 'app-agregar',
  templateUrl: './agregar.component.html',
  styleUrls: ['./agregar.component.css']
})
export class AgregarComponent {
  event = {
    title: '',
    description: '',
    location: '',
    eventDate: ''
  };

  constructor(private appService: AgregarService) {}

  onSubmit() {
    this.appService.createEvent(this.event).subscribe(response => {
      console.log('Evento creado:', response);
      alert('Evento creado exitosamente');
    }, error => {
      console.error('Error al crear el evento:', error);
      alert('Hubo un error al crear el evento');
    });
  }
}
