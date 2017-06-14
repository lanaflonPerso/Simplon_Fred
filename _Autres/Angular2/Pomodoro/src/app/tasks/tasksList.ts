import { Task } from '../shared/task';


export class TasksList{
   public tasksList: Task[]=[];

    constructor(){
        const tasks=[
            {
               
        name: "Coder une table HTML",
        deadline: "feb 10 2017",
        pomodorosQty: 1
      }, {
          
        name: "Réaliser le croquis de la nouvelle page d'accueil",
        deadline: "jun, 10 2017",
        pomodorosQty: 2
      }, {
          
        name: "Styliser la table avec les styles Bootstrap",
        deadline: "may 14 2017",
        pomodorosQty: 1
      }, {
          
        name: "Renforcer le SEO avec un sitemap.xml personnalisé",
        deadline: "feb 14 2017",
        pomodorosQty: 3
      }
        ];

        this.tasksList= tasks.map(task=>{
            return{
                
                name:task.name,
                deadline : new Date(task.deadline),
                pomodorosQty: task.pomodorosQty,
                isSelected : false
            };
        });
    }

}