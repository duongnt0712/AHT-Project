import { Component, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';

@Component({
    selector: 'app-root', //document.querySelector('app-root'); <app-root></app-root>
//   templateUrl: './app.component.html',
    template: `
    <h1 [ngClass]="{  'with-border': withBorder }" 
        [ngStyle]="styleObj" 
        (mouseover)="onTextMouseOver()" 
        (mouseout)="onTextMouseOut()"
        > Welcome to {{ title }}</h1>
    <!-- <h1 [textContent]="title"></h1> -->
    <img src="{{ imgSrc }}" alt="">
    <button (click)="onButtonClick()">{{ withBorder ? 'Hide' : 'Show'}}</button>
    <app-hello [text]="title"></app-hello>
    <app-hi></app-hi>
    `,
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnChanges, OnDestroy {
  title = 'DuongNT';
  imgSrc = 'https://picsum.photos/id/1/200/300';
  textColor = 'green';
  bgColor = '#eee';
  styleObj = {color: this.textColor, background: this.bgColor};

  withBorder = true;

  ngOnInit(): void {
      
  }

  ngOnChanges(changes: SimpleChanges): void {
      
  }

  ngOnDestroy(): void {
      
  }

  onTextMouseOver() {
    this.textColor = 'blue';
  }

  onTextMouseOut() {
    this.textColor = 'green';
  }

  onButtonClick() {
      this.withBorder = !this.withBorder;
  }

  
}
