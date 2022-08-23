import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SBannerService } from 'src/app/service/s-banner';
import { TokenService } from 'src/app/service/token.service';
import { Banner } from 'src/model/banner';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.css']
})
export class BannerComponent implements OnInit {
  banner: Banner[] = [];


  nombre: string = '';
  img: string = '';

  constructor(private sBanner: SBannerService, private tokenService: TokenService, private router: Router) { }

  
  isLogged = false;

  ngOnInit(): void {
    this.cargarBanner();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

    }

    cargarBanner(): void {
      this.sBanner.lista().subscribe(data => {this.banner = data;})
    }

    onCreate(): void {
      const banner = new Banner(this.nombre, this.img);
      this.sBanner.save(banner).subscribe(
        data =>{
          alert("Banner agregado");
          this.router.navigate(['']);
        },err =>{
          alert("Error");
          this.router.navigate(['']);
        }
      )
        } 

        delete(id?: number){
          if(id != undefined){
            this.sBanner.delete(id).subscribe(
              data => {
                this.cargarBanner();
              }, err => {
                alert("Error");
                this.router.navigate(['']);
              }
            )
          }      

    }
      

  }
