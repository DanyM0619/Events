import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AgregarComponent } from './agregar/agregar.component';
import { EditarComponent } from './editar/editar.component';
import { EliminarComponent } from './eliminar/eliminar.component';

const routes: Routes = [
  { path: '', redirectTo: '**', pathMatch: 'full'},
  { path: 'Agregar', component: AgregarComponent},
  { path: 'Editar', component: EditarComponent},
  { path: 'Eliminar', component: EliminarComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
