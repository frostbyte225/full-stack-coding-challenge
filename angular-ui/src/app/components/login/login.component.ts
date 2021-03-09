import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string;
  password: string;
  message: any;

  constructor(private router: Router, private service:LoginService) { }

  ngOnInit(): void {
  }

  navigateToRegistration() {
    this.router.navigate(["/register"]);
  }

  navigateToWelcome() {
    this.router.navigate(["/home"])
  }

  login() {
    let res = this.service.login(this.email, this.password);
    res.subscribe(data => {
      console.log(data);
    })
    this.navigateToWelcome();
  }

}
