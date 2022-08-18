export class Proyecto {
    id? : number;
    nombre : string;
    descripcion: string;
    fecha: string;
    link: string;
    img: string;  
    

    constructor(nombre: string, descripcion: string, fecha: string, link: string, img: string) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.link = link;        
        this.img = img;

    }
}
