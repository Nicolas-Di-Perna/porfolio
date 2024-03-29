import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { LogoAPComponent } from './components/logo-ap/logo-ap.component';
import { RedesComponent } from './components/redes/redes.component';
import { LoginComponent } from './components/login/login.component';
import { BannerComponent } from './components/banner/banner.component';
import { PerfilComponent } from './components/perfil/perfil.component';
import { ExperienciaComponent } from './components/experiencia/experiencia.component';
import { EstudiosComponent } from './components/estudios/estudios.component';
import { SkillsComponent } from './components/skills/skills.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { ProyectosComponent } from './components/proyectos/proyectos.component';

import { ContactarmeComponent } from './components/contactarme/contactarme.component';
import { HomeComponent } from './components/home/home.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { EditexpeComponent } from './components/experiencia/modal/editexpe/editexpe.component';
import { EditestudioComponent } from './components/estudios/modal/editestudio/editestudio.component';
import { EditskillComponent } from './components/skills/modal/editskill/editskill.component';
import { EditproyectoComponent } from './components/proyectos/modal/editproyecto/editproyecto.component';
import { EditperfilComponent } from './components/perfil/modal/editperfil/editperfil.component';
import { EditbannerComponent } from './components/banner/modal/editbanner/editbanner.component';
import { EditredesComponent } from './components/redes/modal/editredes/editredes.component';
import { ConsultasComponent } from './components/contactarme/consultas/consultas.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LogoAPComponent,
    RedesComponent,
    LoginComponent,
    BannerComponent,
    PerfilComponent,
    ExperienciaComponent,
    EstudiosComponent,
    SkillsComponent,
    ProyectosComponent,
    ContactarmeComponent,
    HomeComponent,
    EditexpeComponent,
    EditestudioComponent,
    EditskillComponent,
    EditproyectoComponent,
    EditperfilComponent,
    EditbannerComponent,
    EditredesComponent,
    ConsultasComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgCircleProgressModule.forRoot({}),
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
