import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditexpeComponent } from './components/experiencia/modal/editexpe/editexpe.component';

import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  {path:'',component: HomeComponent},
  {path:'login',component: LoginComponent},
  {path:'home',component: HomeComponent},
  {path:'editexp/:id', component: EditexpeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
