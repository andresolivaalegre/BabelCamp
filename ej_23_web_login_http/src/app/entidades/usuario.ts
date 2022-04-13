class Usuario {
  public mail: string;
  public password: string;
 
  constructor(mail: string, password: string) {
    this.mail = mail;
    this.password = password;
  }

  public getMail(): string {
    return this.mail ;
  }
  public getPassword(): string {
      return this.password ;
  }

  public setMail(userEmail:string) {
    this.mail=userEmail ;
  }
  public setPassword(pswd:string){
    this.password=pswd;
  }
     
}
export{Usuario}