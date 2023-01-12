import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-view2',
  templateUrl: './view2.component.html',
  styleUrls: ['./view2.component.css']
})
export class View2Component implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  back(){
    this.router.navigate(['/view0'])
  }
}
