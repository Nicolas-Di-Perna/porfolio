import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SProyectoService } from 'src/app/service/s-proyecto';
import { TokenService } from 'src/app/service/token.service';
import { Proyecto } from 'src/model/proyecto';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {
  proyec: Proyecto [] = [];

  nombre: string = '';
  descripcion: string = '';
  fecha: string = '';
  link: string = '';  
  img: string = '';

  constructor(private sProyecto: SProyectoService, private tokenService: TokenService, private router: Router) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarProyecto();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

    }

    cargarProyecto(): void {
      this.sProyecto.lista().subscribe(data => {this.proyec = data;})
    }

    onCreate(): void {
      const proyecto = new Proyecto(this.nombre, this.descripcion, this.fecha, this.link, this.img);
      this.sProyecto.save(proyecto).subscribe(
        data =>{
          alert("Proyecto agregado");
          this.router.navigate(['']);
        },err =>{
          alert("Error");
        }
      )
        } 

        delete(id?: number){
          if(id != undefined){
            this.sProyecto.delete(id).subscribe(
              data => {
                this.cargarProyecto();
              }, err => {
                alert("Error");
                this.router.navigate(['']);
              }
            )
          }      

    }
      

  }