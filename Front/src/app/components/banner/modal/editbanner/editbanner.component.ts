import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SBannerService } from 'src/app/service/s-banner';
import { Banner } from 'src/model/banner';

@Component({
  selector: 'app-editbanner',
  templateUrl: './editbanner.component.html',
  styleUrls: ['./editbanner.component.css']
})
export class EditbannerComponent implements OnInit {

  banner : Banner = null;

  constructor(private sBanner: SBannerService, private activatedRouter: ActivatedRoute,
    private router: Router) { }

 
    ngOnInit(): void {
      const id = this.activatedRouter.snapshot.params['id'];
      this.sBanner.detail(id).subscribe(
        data =>{
          this.banner = data;
        }, err =>{
          alert("Error al modificar el banner");
          this.router.navigate(['']);
        }
      )
    }
  
    onUpdate(): void{
      const id = this.activatedRouter.snapshot.params['id'];
      this.sBanner.update(id, this.banner).subscribe(
        data => {
          this.router.navigate(['']);
        }, err =>{
           alert("Error al modificar el banner");
           this.router.navigate(['']);
        }
      )
    }
  
  }
