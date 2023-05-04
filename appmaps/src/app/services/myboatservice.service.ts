import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders,HttpErrorResponse,HttpParams } from '@angular/common/http';
import { Observable,throwError,retry,catchError } from 'rxjs';
import { Nave } from '../model/nave';
import { Info } from '../model/info';
import { Plugins } from '@capacitor/core';
const {Storage} = Plugins;
@Injectable({
  providedIn: 'root'
})
export class MyboatserviceService {
private baseUrl: string = 'https://myboatcore.arsinfo.it/';
private navi_path: string = 'navi';
private info_path: string = 'info';
private id:string |undefined;
private CONFING_STORAGE:string='myboatserviceid';
  constructor(private http:HttpClient) { 

  }
  httpOptions={

  
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    })
  }
  creaNave(item:Nave): Observable<Nave>{
    console.log(item);
    return this.http.post<Nave>(this.baseUrl+this.navi_path,JSON.stringify(item),this.httpOptions).pipe(retry(2),catchError(this.handleError) )

  }
  handleError(errore:HttpErrorResponse){

return throwError(errore.message);
  }
  getNaveById(id: string): Observable<Nave>{
    console.log(id);
    return this.http.get<Nave>(this.baseUrl+this.navi_path+'/'+id).pipe(retry(2),catchError(this.handleError));
  }
  getId(){
    return this.id;
  }
  async saveid(id:string){
  await Storage['set']({key:this.CONFING_STORAGE, value: id});
  this.id=id;
  }
  async loadid(){
    const savedid = await Storage['get']({key:this.CONFING_STORAGE});
    this.id=savedid;
  }
}
