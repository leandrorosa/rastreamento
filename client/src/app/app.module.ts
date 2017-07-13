import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';

import {routing} from "./app.routes";
import { PrecoComponent } from './preco/preco.component';
import { ContatoComponent } from './contato/contato.component';
import { HomeComponent } from './home/home.component'; 

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    PrecoComponent,
    ContatoComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule, routing
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
