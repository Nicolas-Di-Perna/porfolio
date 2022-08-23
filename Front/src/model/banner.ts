export class Banner {
    id? : number;
    img: string;  
    nombre: string; 

    constructor(img: string, nombre: string) {
                this.img = img;
                this.nombre = nombre;
    }
}