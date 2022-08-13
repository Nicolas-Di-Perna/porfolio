import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SExperienciaService } from 'src/app/service/s-experiencia.service';
import { TokenService } from 'src/app/service/token.service';
import { Experiencia } from 'src/model/experiencia';

@Component({
  selector: 'app-editexpe',
  templateUrl: './editexpe.component.html',
  styleUrls: ['./editexpe.component.css']
})
export class EditexpeComponent implements OnInit {
expLab : Experiencia = null;

  constructor(private sExperiencia: SExperienciaService, private activatedRouter: ActivatedRoute,
    private router: Router) { }

    ngOnInit(): void {
      const id = this.activatedRouter.snapshot.params['id'];
      this.sExperiencia.detail(id).subscribe(
        data =>{
          this.expLab = data;
        }, err =>{
          alert("Error al modificar experiencia");
          this.router.navigate(['']);
        }
      )
    }
  
    onUpdate(): void{
      const id = this.activatedRouter.snapshot.params['id'];
      this.sExperiencia.update(id, this.expLab).subscribe(
        data => {
          this.router.navigate(['']);
        }, err =>{
           alert("Error al modificar experiencia");
           this.router.navigate(['']);
        }
      )
    }
  
  }
