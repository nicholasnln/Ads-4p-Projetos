import { Routes } from '@angular/router';
import { LoginComponent } from './components/layout/login/login.component';
import { EquipeComponent } from './components/equipe/equipe.component';
import { PrincipalComponent } from './components/layout/principal/principal.component';
import { CampeonatoComponent } from './components/campeonato/campeonato.component';
import { QualiferCampeonatoComponent } from './components/layout/qualifer-campeonato/qualifer-campeonato.component';
import { BracketComponent } from './components/layout/bracket/bracket.component';

export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {
    path: 'home', 
    component: CampeonatoComponent,
    children: [
      { path: 'tabela', component: QualiferCampeonatoComponent },
      { path: 'playoff', component: BracketComponent }
    ],
  }, 
  { path: 'login', component: LoginComponent },
  {
    path: 'admin',
    component: PrincipalComponent,
    children: [
      { path: '', component: CampeonatoComponent },
      { path: 'equipe', component: EquipeComponent },
    ],
  },
];
