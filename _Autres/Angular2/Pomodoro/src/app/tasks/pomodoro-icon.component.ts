import { Component, Input, OnInit } from '@angular/core';
import { Task } from '../shared/task';
//import { TaskTooltipDirective } from './taskTooltip.directive';

@Component({
    selector:'pomodoro-icon',
    template:`
        <img *ngFor="let icon of icons"
            src="../app/shared/assets/img/pomodoro-rosso.gif"
            width="50">`
})
export class PomodoroIconComponent implements OnInit{
    @Input() task:Task;
    icons:Object[]

    constructor(){
        this.icons=new Array();
    }

    ngOnInit(): void{
        this.icons.length=this.task.pomodorosQty;
        this.icons.fill({name: this.task.name});
    }
}
