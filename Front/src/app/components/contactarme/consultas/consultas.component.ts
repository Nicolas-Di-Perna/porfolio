import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SContactameService } from 'src/app/service/s-contactame';
import { TokenService } from 'src/app/service/token.service';
import { Contactame } from 'src/model/contactame';

@Component({
  selector: 'app-consultas',
  templateUrl: './consultas.component.html',
  styleUrls: ['./consultas.component.css']
})
export class ConsultasComponent implements OnInit {

  mensa: Contactame[] = [];

  nombre: string = '';
  telefono: string = '';
  correo: string = '';
  mensaje: string = '';

  constructor(private sContactame: SContactameService,  private router: Router, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarConsultas();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

    }

    cargarConsultas(): void {
      this.sContactame.lista().subscribe(data => {this.mensa = data;})
    }

}
