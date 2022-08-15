import { Component, OnInit } from '@angular/core';
import { SEstudioService } from 'src/app/service/s-estudio.service';
import { TokenService } from 'src/app/service/token.service';
import { Estudio } from 'src/model/estudio';

@Component({
  selector: 'app-estudios',
  templateUrl: './estudios.component.html',
  styleUrls: ['./estudios.component.css']
})
export class EstudiosComponent implements OnInit {

  estu: Estudio[] = [];
  
  nombre: string = '';
  instituto: string = '';
  fechaInicio: string = '';
  fechaFin: string = '';
  titulo: string = '';
  img: string = '';


  constructor(private sEstudio: SEstudioService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarEstudio();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

    }

    cargarEstudio(): void {
      this.sEstudio.lista().subscribe(data => {this.estu = data;})
    }

    onCreate(): void {
      const expe = new Estudio(this.nombre, this.instituto, this.fechaInicio, this.fechaFin,this.titulo, this.img);
      this.sEstudio.save(expe).subscribe(
        data =>{
          alert("Estudio agregado");
        },err =>{
          alert("Error");
        }
      )
        } 

        delete(id?: number){
          if(id != undefined){
            this.sEstudio.delete(id).subscribe(
              data => {
                this.cargarEstudio();
              }, err => {
                alert("Error");
              }
            )
          }      

    }
      

  }