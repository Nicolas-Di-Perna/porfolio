export class Social{
    id?: number;
    nombreS: string;
    icono: string;
    link: string;
   

    constructor(nombreS: string,icono: string,link: string){
        this.nombreS = nombreS;
        this.icono =icono;
        this.link= link;
    
    }
}