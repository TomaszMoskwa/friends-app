import { Component, Input, OnInit } from '@angular/core';
import { Friend } from '../model/friend';

@Component({
  selector: 'app-friend-list',
  templateUrl: './friend-list.component.html',
  styleUrls: ['./friend-list.component.css']
})
export class FriendListComponent implements OnInit {
  @Input() friends: Friend[] = []

  visibleColumnNames: string[] = [
    'friend-id',
    'first-name',
    'last-name',
    'birthdate'
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
