import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SSocialService } from 'src/app/service/social.service';
import { Social } from 'src/model/social.model';

@Component({
  selector: 'app-editredes',
  templateUrl: './editredes.component.html',
  styleUrls: ['./editredes.component.css']
})
export class EditredesComponent implements OnInit {

  red : Social = null;

  constructor(private sSocial: SSocialService, private activatedRouter: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sSocial.detail(id).subscribe(
      data =>{
        this.red = data;
      }, err =>{
        alert("Error al modificar una red social");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.sSocial.update(id, this.red).subscribe(
      data => {
        this.router.navigate(['']);
      }, err =>{
         alert("Error al modificar una red social");
         this.router.navigate(['']);
      }
    )
  }

}
