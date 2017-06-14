import { Component, OnInit } from '@angular/core';
import { Task } from '../shared/task';
//import { TasksList } from './tasksList';
import { TaskListService } from '../shared/Services/TaskListService.service';
import { FormattedTimePipe, SelectededOnlyPipe } from '../shared/app.pipes';
//import { TaskTooltipDirective } from './taskTooltip.directive';

@Component({
  selector: 'pomodoro-tasks',
  templateUrl: 'tasks.component.html',
  styleUrls:['/src/app/tasks/tasks.component.css']  ,
  moduleId:module.id,
  providers:[TaskListService]
})
export class TasksComponent implements OnInit  {
  today:Date;
  tasks: Task[];
  nbPomodoros:number;
  image:string;
  message:string;
  selectedTaskName:string;

   constructor(private taskListService:TaskListService){
     this.image='/src/app/shared/assets/img/pomodoro-rosso.gif';
     //const tasksService: TasksList= new TasksList();
     //this.tasks= tasksService.tasksList;
     this.today=new Date();
     this.nbPomodoros=0;
     //this.updateNbPomodoros();
     this.changeMessage();
   }

   changeMessage():void{
     this.message= (this.nbPomodoros>0)? `${this.nbPomodoros} tomates ` : 'Aucune tomate ' ;
   }

  OnClick(task: Task):void{
    task.isSelected=!task.isSelected;
    //this.updateNbPomodoros();
    this.changeMessage();
  }

  private updateNbPomodoros():void{
    if (this.tasks){
    this.nbPomodoros= this.tasks
      .filter((task:Task)=>task.isSelected)
      .reduce((pomodoros:number, selectedTask:Task)=>{
        return pomodoros + selectedTask.pomodorosQty;
      },0);
    }
  }

  ngOnInit():void{
    this.taskListService.getTasks()
      .then(tasks=>this.tasks=tasks)
      .catch(err=>console.log("erreur"));
      //console.log('nbPomodoros :' + this.tasks.length);
      this.updateNbPomodoros();
  }
}  