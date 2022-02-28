import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HelloComponent } from './components/hello/hello.component';
import { HiComponent } from './components/hi/hi.component';

@NgModule({ // @Decorator //metadata
  declarations: [
    AppComponent,
    HelloComponent,
    HiComponent
  ],
  imports: [
    BrowserModule,
    // RouterModule,
    // FormsModule,
    AppRoutingModule
  ],
  providers: [], 
  bootstrap: [AppComponent]
})
export class AppModule { }
