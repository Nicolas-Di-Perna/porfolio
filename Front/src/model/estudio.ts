export class Estudio {
    id? : number;
    nombre : string;
    instituto: string;
    fechaInicio: string;
    fechaFin: string;
    titulo: string;
    img: string;  

    constructor(nombre: string, instituto: string, fechaInicio: string, fechaFin: string, titulo: string, img: string) {
        this.nombre = nombre;
        this.instituto = instituto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.titulo = titulo;
        this.img = img;

    }
}
