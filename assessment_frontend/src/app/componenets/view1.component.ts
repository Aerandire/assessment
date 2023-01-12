import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-view1',
  templateUrl: './view1.component.html',
  styleUrls: ['./view1.component.css']
})
export class View1Component implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  cancel(){
    this.router.navigate(['/view0'])
  }

}
