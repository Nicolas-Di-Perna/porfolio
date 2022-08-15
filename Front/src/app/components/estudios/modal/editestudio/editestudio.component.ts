import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SEstudioService } from 'src/app/service/s-estudio.service';
import { Estudio } from 'src/model/estudio';

@Component({
  selector: 'app-editestudio',
  templateUrl: './editestudio.component.html',
  styleUrls: ['./editestudio.component.css']
})
export class EditestudioComponent implements OnInit {
  estu : Estudio = null;


  constructor(private sEstudio: SEstudioService, private activatedRouter: ActivatedRoute,
    private router: Router) { }

    ngOnInit(): void {
      const id = this.activatedRouter.snapshot.params['id'];
      this.sEstudio.detail(id).subscribe(
        data =>{
          this.estu = data;
        }, err =>{
          alert("Error al modificar el estudio");
          this.router.navigate(['']);
        }
      )
    }
  
    onUpdate(): void{
      const id = this.activatedRouter.snapshot.params['id'];
      this.sEstudio.update(id, this.estu).subscribe(
        data => {
          this.router.navigate(['']);
        }, err =>{
           alert("Error al modificar el estudio");
           this.router.navigate(['']);
        }
      )
    }
  
  }
