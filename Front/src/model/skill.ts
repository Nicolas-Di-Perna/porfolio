export class Skill {
    id? : number;
    nombre : string;
    porcentaje: number;
    icono: string;
     
    

    constructor(nombre: string, porcentaje: number, icono: string) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.icono = icono;
        

    }
}
 