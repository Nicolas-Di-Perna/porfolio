import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SPersonaService } from 'src/app/service/s-persona';
import { Persona } from 'src/model/persona';
;

@Component({
  selector: 'app-editperfil',
  templateUrl: './editperfil.component.html',
  styleUrls: ['./editperfil.component.css']
})
export class EditperfilComponent implements OnInit {
  perso : Persona = null;

  constructor(private sPersona: SPersonaService, private activatedRouter: ActivatedRoute,
    private router: Router) { }

    
    ngOnInit(): void {
      const id = this.activatedRouter.snapshot.params['id'];
      this.sPersona.detail(id).subscribe(
        data =>{
          this.perso = data;
        }, err =>{
          alert("Error al modificar la persona");
          this.router.navigate(['']);
        }
      )
    }
  
    onUpdate(): void{ 
      const id = this.activatedRouter.snapshot.params['id'];
      this.sPersona.update(id, this.perso).subscribe(
        data => {
          this.router.navigate(['']);
        }, err =>{
           alert("Error al modificar la persona");
           this.router.navigate(['']);
        }
      )
    }
  
  }
