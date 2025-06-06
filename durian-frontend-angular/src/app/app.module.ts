import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { TreeManagerComponent } from './components/tree-manager.component';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [AppComponent, TreeManagerComponent],
  imports: [BrowserModule, FormsModule, HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule {}