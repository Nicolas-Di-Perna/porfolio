import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditestudioComponent } from './components/estudios/modal/editestudio/editestudio.component';
import { EditexpeComponent } from './components/experiencia/modal/editexpe/editexpe.component';

import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  {path:'',component: HomeComponent},
  {path:'login',component: LoginComponent},
  {path:'home',component: HomeComponent},
  {path:'editexp/:id', component: EditexpeComponent},
  {path:'editestudio/:id', component: EditestudioComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
