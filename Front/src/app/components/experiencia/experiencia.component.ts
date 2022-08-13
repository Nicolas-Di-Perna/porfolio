import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SExperienciaService } from 'src/app/service/s-experiencia.service';
import { TokenService } from 'src/app/service/token.service';
import { Experiencia } from 'src/model/experiencia';


@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {
  expe: Experiencia[] = [];

  expLab : Experiencia = null;

  nombreE: string = '';
  descripcionE: string = '';
  fechaInicio: string = '';
  fechaFin: string = '';
  puestoE: string = '';
  img: string = '';

  constructor(private sExperiencia: SExperienciaService, private tokenService: TokenService) { }

    isLogged = false;

  ngOnInit(): void {
    this.cargarExperiencia();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

    }

    cargarExperiencia(): void {
      this.sExperiencia.lista().subscribe(data => {this.expe = data;})
    }

    onCreate(): void {
      const expe = new Experiencia(this.nombreE, this.descripcionE, this.fechaInicio, this.fechaFin,this.puestoE, this.img);
      this.sExperiencia.save(expe).subscribe(
        data =>{
          alert("Experiencia agregada");
        },err =>{
          alert("Error");
        }
      )
        } 

        delete(id?: number){
          if(id != undefined){
            this.sExperiencia.delete(id).subscribe(
              data => {
                this.cargarExperiencia();
              }, err => {
                alert("Error");
              }
            )
          }      

    }
      

  }
