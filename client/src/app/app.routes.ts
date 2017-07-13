import {RouterModule, Routes} from "@angular/router";
import {AppComponent} from "./app.component";
import {PrecoComponent} from "./preco/preco.component";
import {ContatoComponent} from "./contato/contato.component";

const appRoutes: Routes = [
    { path: '', component: AppComponent},    
    { path: 'preco', component: PrecoComponent}, 
    { path: 'contato', component: ContatoComponent}, 
    { path: '**', component: AppComponent}
];

export const routing = RouterModule.forRoot(appRoutes);