import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SSkillService } from 'src/app/service/s-skill';
import { Skill } from 'src/model/skill';

@Component({
  selector: 'app-editskill',
  templateUrl: './editskill.component.html',
  styleUrls: ['./editskill.component.css']
})
export class EditskillComponent implements OnInit {
  skill : Skill = null;

  constructor(private sSkill: SSkillService, private activatedRouter: ActivatedRoute,
    private router: Router) { }

    ngOnInit(): void {
      const id = this.activatedRouter.snapshot.params['id'];
      this.sSkill.detail(id).subscribe(
        data =>{
          this.skill = data;
        }, err =>{
          alert("Error al modificar el skill");
          this.router.navigate(['']);
        }
      )
    }
  
    onUpdate(): void{
      const id = this.activatedRouter.snapshot.params['id'];
      this.sSkill.update(id, this.skill).subscribe(
        data => {
          this.router.navigate(['']);
        }, err =>{
           alert("Error al modificar el skill");
           this.router.navigate(['']);
        }
      )
    }
  
  }