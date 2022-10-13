import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AuthenticationServiceService } from '../authentication-service/authentication-service.service';
import { BACKEND_BASE_URL } from '../model/constants';
import { Friend } from '../model/friend';

@Component({
  selector: 'app-user-friends-list',
  templateUrl: './user-friends-list.component.html',
  styleUrls: ['./user-friends-list.component.css']
})
export class UserFriendsListComponent implements OnInit {
  friends: Friend[] = []

  constructor(
    private httpClient: HttpClient,
    private authService: AuthenticationServiceService
  ) { }

  ngOnInit(): void {
    this.httpClient.get<Friend[]>(BACKEND_BASE_URL + 'friend/' + this.authService.getUserId())
    .subscribe({
      next: (data) => {
        this.friends = data;
      },
      error: (error) =>{
        console.log('Error: ' + error)
      }
    })
  }

}
