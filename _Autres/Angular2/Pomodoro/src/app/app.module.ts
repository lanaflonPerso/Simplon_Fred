import { NgModule, LOCALE_ID }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';

//Pour les Routes
import { RouterModule } from '@angular/router';
import { appRoutes } from './app.routes';

import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryTasksService } from './shared/Services/inMemoryTasksService';

import { AppComponent }  from './app.component';
import { TasksComponent } from './tasks/tasks.component';
import { PomodoroIconComponent } from './tasks/pomodoro-icon.component';
import { FormattedTimePipe,SelectededOnlyPipe } from './shared/app.pipes';
import { TaskTooltipDirective } from './tasks/taskTooltip.directive';
import { PomodoroTimerComponent } from './timer/timer.component';
import { HomeComponent } from './Home/Home.component';

@NgModule({
  imports:      [ BrowserModule, HttpModule, 
                  InMemoryWebApiModule.forRoot(InMemoryTasksService),
                  RouterModule.forRoot(appRoutes), ],
  declarations: [ AppComponent, PomodoroIconComponent, TasksComponent,
                PomodoroTimerComponent,
                FormattedTimePipe, SelectededOnlyPipe,
                TaskTooltipDirective,
                HomeComponent
],
  providers:[{provide:LOCALE_ID, useValue:"fr-FR"}],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
