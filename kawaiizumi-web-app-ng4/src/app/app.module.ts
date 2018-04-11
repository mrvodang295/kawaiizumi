import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { IncubationManagementComponent } from './incubation-management/incubation-management.component';


@NgModule({
  declarations: [
    AppComponent,
    IncubationManagementComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
