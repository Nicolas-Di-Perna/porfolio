export class Experiencia {
    id? : number;
    nombreE : string;
    descripcionE: string;
    fechaInicio: string;
    fechaFin: string;
    puestoE: string;
    img: string;  
    

    constructor(nombreE: string, descripcionE: string, fechaInicio: string, fechaFin: string, puestoE: string, img: string) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.puestoE = puestoE;
        this.img = img;

    }
}
