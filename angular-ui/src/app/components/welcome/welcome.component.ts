import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/services/login.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  users: any;
  constructor(private service:LoginService) { }

  ngOnInit(): void {
  }

  getUsers() {
    let res = this.service.getUsers();
    res.subscribe(data => this.users = data);
  }

}
