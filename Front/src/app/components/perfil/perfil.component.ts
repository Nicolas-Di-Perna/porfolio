import { Component, OnInit } from '@angular/core';
import { PersonaService } from 'src/app/service/persona.service';
import { persona } from 'src/model/persona.model';

import { SocialService } from 'src/app/service/social.service';
import { social } from 'src/model/social.model';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {
  persona: persona = new persona("","","","","","","","","","","");

  social: social = new social("","","","");

  constructor(public personaService: PersonaService, public socialService: SocialService) { }

  ngOnInit(): void {
    this.personaService.getPerson().subscribe(data => {this.persona = data})

    this.socialService.getSocial().subscribe(data => {this.social = data})
  }

}


