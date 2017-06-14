import { Routes } from '@angular/router';

import { HomeComponent } from './Home/Home.component';
import { TasksComponent } from './tasks/tasks.component';
import { PomodoroTimerComponent } from './timer/timer.component';

export const appRoutes:Routes=[
    {path: '', component:HomeComponent},
    {path:'tasks', component:TasksComponent},
    {path:'timer', component:PomodoroTimerComponent}
]