import { Component, QueryList, ViewChildren } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { HeureSupComponent } from '../heure-sup/heure-sup.component';

@Component({
  selector: 'app-calcul',
  standalone: false,
  templateUrl: './calcul.component.html',
  styleUrl: './calcul.component.css'
})

export class CalculComponent {
  calcul = new FormGroup({
    date_debut: new FormControl('', [Validators.required]),
    date_fin: new FormControl('', [Validators.required])
  });

  @ViewChildren(HeureSupComponent) heure_sups!: QueryList<HeureSupComponent>; 

  onShowHeuresSup() {
    this.heure_sups.forEach(component => component.getAllHeuresSup());
  }
}

