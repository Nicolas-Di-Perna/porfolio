export class persona{
    id?: Number;
    nombre: string;
    apellido: string;
    domicilio: string;
    fechaNac: string;
    edad: string;
    correo: string;
    telefono: string;
    usuario: string;
    password: string;
    img: string;
    sobreMi: string;


constructor(nombre: string,apellido: string,domicilio: string,fechaNac: string,edad: string,correo: string,telefono: string,usuario: string,password: string,img: string,sobreMi: string){
    this.nombre = nombre;
    this.apellido =apellido;
    this.domicilio= domicilio;
    this.fechaNac= fechaNac;
    this.edad = edad;
    this.correo = correo;
    this.telefono = telefono;
    this.usuario = usuario;
    this.password = password;
    this.img = img;
    this.sobreMi = sobreMi;
}
}