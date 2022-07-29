export class persona{
    id?: Number;
    nombre: String;
    apellido: String;
    domicilio: String;
    fechaNac: String;
    edad: String;
    correo: String;
    telefono: String;
    usuario: String;
    password: String;
    img: String;
    sobreMi: String;


constructor(nombre: String,apellido: String,domicilio: String,fechaNac: String,edad: String,correo: String,telefono: String,usuario: String,password: String,img: String,sobreMi: String){
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