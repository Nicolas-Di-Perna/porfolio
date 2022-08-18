import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SProyectoService } from 'src/app/service/s-proyecto';
import { Proyecto } from 'src/model/proyecto';

@Component({
  selector: 'app-editproyecto',
  templateUrl: './editproyecto.component.html',
  styleUrls: ['./editproyecto.component.css']
})
export class EditproyectoComponent implements OnInit {
  proyec : Proyecto = null;

  constructor(private sProyecto: SProyectoService, private activatedRouter: ActivatedRoute,
    private router: Router) { }

    ngOnInit(): void {
      const id = this.activatedRouter.snapshot.params['id'];
      this.sProyecto.detail(id).subscribe(
        data =>{
          this.proyec = data;
        }, err =>{
          alert("Error al modificar el proyecto");
          this.router.navigate(['']);
        }
      )
    }
  
    onUpdate(): void{
      const id = this.activatedRouter.snapshot.params['id'];
      this.sProyecto.update(id, this.proyec).subscribe(
        data => {
          this.router.navigate(['']);
        }, err =>{
           alert("Error al modificar el proyecto");
           this.router.navigate(['']);
        }
      )
    }
  
  }

