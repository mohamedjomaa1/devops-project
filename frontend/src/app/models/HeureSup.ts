import { Employe } from "./Employe";
import { Tarif } from "./Tarif";

export class HeureSup{

    public id?:number;

    public date!:Date;

    public nb_heures!:number;

    public employe!:Employe;

    public tarif!:Tarif;
    
}