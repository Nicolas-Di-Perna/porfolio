export class social{
    id?: Number;
    nombre: String;
    icono: String;
    link: String;
    idpersona: String;

    constructor(nombre: String,icono: String,link: String,idpersona: String){
        this.nombre = nombre;
        this.icono =icono;
        this.link= link;
        this.idpersona = idpersona;
    }
}