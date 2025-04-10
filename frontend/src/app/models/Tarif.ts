import { HeureSup } from "./HeureSup";


export class Tarif{

    public id?:number;

    public type_jour!:string;

    public tarif!:number;

    public heures_sup!:HeureSup[];

}