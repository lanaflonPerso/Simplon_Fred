import { Pipe, PipeTransform } from '@angular/core';
import { Task } from './task';


@Pipe({
    name:'pomodoroFormattedTime'
})
export class FormattedTimePipe implements PipeTransform {
   transform(nbTomates:number):string{
       let totalMinutes= nbTomates*25;
       let minutes:number=totalMinutes%60;
       let hours:number= Math.floor(totalMinutes/60);
       return `${hours}h:${minutes}m`;
   } 
}


@Pipe({
  name: 'pomodoroSelectedOnly',
  pure: false
})
export class SelectededOnlyPipe implements PipeTransform {
  transform(tasks: Task[], ...args: any[]): Task[] {
    if(tasks){
    return tasks.filter((task: Task) => {
      return task.isSelected === args[0];
    });
    }
  }
}