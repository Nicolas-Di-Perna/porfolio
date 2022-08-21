import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SPersonaService } from 'src/app/service/s-persona';
import { TokenService } from 'src/app/service/token.service';
import { Persona } from 'src/model/persona';



@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {

  perso: Persona[] = [];

  nombre: string = '';
  apellido: string = '';
  domicilio: string = '';
  fechaNac: string = '';
  titulo: string = '';
  correo: string = '';
  telefono: string = '';
  usuario: string = '';
  password: string = '';
  img: string = '';
  sobreMi: string = '';

  constructor(public sPersona: SPersonaService, private tokenService: TokenService, private router: Router) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarPersona();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

  }

  cargarPersona(): void {
    this.sPersona.lista().subscribe(data => { this.perso = data; })
  }

  onCreate(): void {
    const perso = new Persona(this.nombre,this.apellido,this.domicilio,this.fechaNac,this.titulo,
      this.correo,this.telefono,this.usuario,this.password,this.img,this.sobreMi);
   
      this.sPersona.save(perso).subscribe(
      data => {
        alert("Persona agregada");
        this.router.navigate(['']);
      }, err => {
        alert("Error");
        this.router.navigate(['']);
      }
    )
  }

  delete(id?: number) {
    if (id != undefined) {
      this.sPersona.delete(id).subscribe(
        data => {
          this.cargarPersona();
        }, err => {
          alert("Error");
          this.router.navigate(['']);
        }
      )
    }

  }


}
