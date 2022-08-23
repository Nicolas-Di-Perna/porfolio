export class Contactame {
    id? : number;
    nombre: string; 
    telefono: string; 
    correo: string;
    mensaje: string;

    constructor(nombre: string, telefono: string, correo: string, mensaje: string,) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.mensaje = mensaje;
    }
}