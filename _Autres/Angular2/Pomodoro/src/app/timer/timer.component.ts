import { Component } from '@angular/core';

@Component({
  selector: 'pomodoro-timer',
  templateUrl: 'timer.component.html',
  moduleId:module.id
})
export class PomodoroTimerComponent  {
   minutes: number; 
   seconds: number;
   buttonLabel : string;
   image : string;
   isPaused: boolean;

   constructor(){
     this.resetPomodoro();
     //this.image='assets/img/pomodoro-rosso.gif'
     setInterval(()=>this.tick(),1000);
   }

   togglePause():void{
     this.isPaused=!this.isPaused;
     if (this.minutes<24 || this.seconds<59) {
       this.buttonLabel=this.isPaused ?'Continuer':'Pause';
     }
   }

   resetPomodoro():void{
      this.minutes=24;
      this.seconds=59;
      this.buttonLabel='Lancer';
      this.togglePause();
    }

    private tick():void{
      if (!this.isPaused) {
        this.buttonLabel='Pause';

        if (--this.seconds<0) {
          this.seconds=59;
          if (--this.minutes<0) {
            this.resetPomodoro();
          }
        }
      }
    }
  }