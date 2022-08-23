import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SSocialService } from 'src/app/service/social.service';
import { TokenService } from 'src/app/service/token.service';
import { Social } from 'src/model/social.model';

@Component({
  selector: 'app-redes',
  templateUrl: './redes.component.html',
  styleUrls: ['./redes.component.css']
})
export class RedesComponent implements OnInit {
  red: Social[] = [];

  nombreS: string = '';
  icono: string = '';
  link: string = '';

  constructor(public sSocial: SSocialService, private tokenService: TokenService, private router: Router) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarSocial();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

  }

  cargarSocial(): void {
    this.sSocial.lista().subscribe(data => { this.red = data; })
  }

  onCreate(): void {
    const red = new Social(this.nombreS,this.icono,this.link);
   
      this.sSocial.save(red).subscribe(
      data => {
        alert("Red Social agregada");
        this.router.navigate(['']);
      }, err => {
        alert("Error");
        this.router.navigate(['']);
      }
    )
  }

  delete(id?: number) {
    if (id != undefined) {
      this.sSocial.delete(id).subscribe(
        data => {
          this.cargarSocial();
        }, err => {
          alert("Error");
          this.router.navigate(['']);
        }
      )
    }

  }


}
