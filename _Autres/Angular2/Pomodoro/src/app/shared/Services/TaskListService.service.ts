import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Task } from '../task';

@Injectable()
export class TaskListService {

 private  url:string='api/tasks';
 private headers : Headers;
 
 constructor(private http:Http) {
    //this.url='api/tasks';
    this.headers= new Headers({'Content-Type':'application/json'});
 }

 getTasks():Promise<Task[]>{
    return this.http.get(this.url)
        .toPromise()
        .then(response=>response.json().data as Task[])
        .catch(this.HandleError)
 }

 add(task:Task):Promise<Task>{
     return this.http
            .post(this.url,JSON.stringify(task), {headers:this.headers})
            .toPromise()
            .then(res=>res.json().data)
            .catch(this.HandleError)
 }
 
 private HandleError(error:any):Promise<any>{
        console.error('Une erreur est survenue dans la web API', error);
        return Promise.reject(error.message || error);
 }
}