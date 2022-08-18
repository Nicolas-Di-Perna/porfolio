import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SSkillService } from 'src/app/service/s-skill';
import { TokenService } from 'src/app/service/token.service';
import { Skill } from 'src/model/skill';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {

  skill: Skill[] = [];

  nombre: string = '';
  porcentaje: number = 0;
  icono: string = '';
  


  constructor(private sSkill: SSkillService, private tokenService: TokenService, private router: Router) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarSkill();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

    }

    cargarSkill(): void {
      this.sSkill.lista().subscribe(data => {this.skill = data;})
    }

    onCreate(): void {
      const skill = new Skill(this.nombre, this.porcentaje, this.icono);
      this.sSkill.save(skill).subscribe(
        data =>{
          alert("Skill agregada");
          this.router.navigate(['']);
        },err =>{
          alert("Error");
          this.router.navigate(['']);
        }
      )
        } 

        delete(id?: number){
          if(id != undefined){
            this.sSkill.delete(id).subscribe(
              data => {
                this.cargarSkill();
              }, err => {
                alert("Error");
                this.router.navigate(['']);
              }
            )
          }      

    }
      

  }
