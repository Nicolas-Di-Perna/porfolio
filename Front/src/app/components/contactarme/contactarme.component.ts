import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SContactameService } from 'src/app/service/s-contactame';
import { Contactame } from 'src/model/contactame';

@Component({
  selector: 'app-contactarme',
  templateUrl: './contactarme.component.html',
  styleUrls: ['./contactarme.component.css']
})
export class ContactarmeComponent implements OnInit {

  mensa: Contactame[] = [];

  nombre: string = '';
  telefono: string = '';
  correo: string = '';
  mensaje: string = '';

  constructor(private sContactame: SContactameService,  private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const mensa = new Contactame (this.nombre, this.telefono, this.correo, this.mensaje);
    this.sContactame.save(mensa).subscribe(
      data =>{
        alert("Mensaje registrado con exito, te contactare cuanto antes. Gracias");
        this.router.navigate(['']);
      },err =>{
        alert("Error al registrar el mensaje.");
        this.router.navigate(['']);
      }
    )

}

}