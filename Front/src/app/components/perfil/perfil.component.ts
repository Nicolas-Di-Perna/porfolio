import { Component, OnInit } from '@angular/core';
import { PersonaService } from 'src/app/service/persona.service';
import { persona } from 'src/model/persona.model';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {
  persona: persona = new persona("","","");
  constructor(public personaService: PersonaService) { }

  ngOnInit(): void {
    this.personaService.getPerson().subscribe(data => {this.persona = data})
  }

}


