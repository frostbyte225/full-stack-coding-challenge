import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  public login(email:string, password:string): Observable<any> {

    const URL = 'http://localhost:8081/login';

    let headers = new HttpHeaders({
      "Content-Type" : "application/json"
    });

    let body = {
      "email" : email,
      "password" : password
    };

    console.log(body)

    console.log(JSON.stringify(body))


    // return this.http.post<any>(URL, body, { responseType: 'text' as 'json', withCredentials: true});

    return this.http.post("http://localhost:8081/login", body, {headers} );

    // return this.http.post("http://localhost:8081/login/", body, { headers })
  }

  public getUsers() {

    let password = "sheldon";
    let username = "sheldon";

    const headers = new HttpHeaders({
      // btoa = binary to ascii
      Authorization: 'Basic ' + btoa(username + ":" + password)
    });
    return this.http.get("http://localhost:8081/login/", {headers});
  }

}
