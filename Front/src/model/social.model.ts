export class social{
    id?: Number;
    nombre: string;
    icono: string;
    link: string;
    idpersona: string;

    constructor(nombre: string,icono: string,link: string,idpersona: string){
        this.nombre = nombre;
        this.icono =icono;
        this.link= link;
        this.idpersona = idpersona;
    }
}