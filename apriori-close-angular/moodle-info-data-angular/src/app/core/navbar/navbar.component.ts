import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  public title:string = 'Moodle Info Data';

  public mostFrequentCombinationsOptions: string[] = [
    "IP Address - User",
    "Course Module - User",
    "User(Enroller) - User(Enrolling)"
  ];

  public otherOptions: string[] = [
    "User IP Addresses",
    "Deleted files",
    "Most Common Users Participating In Discussions"
  ];
  

  constructor() { }

  ngOnInit() {
  }

}
