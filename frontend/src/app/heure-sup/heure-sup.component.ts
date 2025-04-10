import { Component, EventEmitter, Input, Output } from '@angular/core';
import { HeureSup } from '../models/HeureSup';
import { HeureSupService } from '../services/heure-sup/heure-sup.service';


@Component({
  selector: 'app-heure-sup',
  standalone: false,
  templateUrl: './heure-sup.component.html',
  styleUrl: './heure-sup.component.css'
})
export class HeureSupComponent {
  listHeuresSup!:HeureSup[];

  constructor(private _service:HeureSupService){

  }

  getAllHeuresSup(){
    this._service.getAllHeureSup().subscribe(l=>this.listHeuresSup=l)
  }

  saveHeureSup(hs:HeureSup){
    this._service.saveHeureSup(hs).subscribe();
  }

  updateHeureSup(id:number,hs:HeureSup){
    this._service.updateHeureSup(id,hs).subscribe();
  }

  deleteHeureSup(id:number){
    this._service.deleteHeureSup(id).subscribe();
  }

  getHeureSup(id:number){
    this._service.getHeureSup(id).subscribe();
  }

  @Input() date_debut!:Date
  @Input() date_fin!:Date
  @Output() heureSupsDisplayed=new EventEmitter<HeureSup[]>()
}
