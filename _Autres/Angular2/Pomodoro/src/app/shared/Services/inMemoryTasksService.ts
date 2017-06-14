import {InMemoryDbService } from 'angular-in-memory-web-api';

export class InMemoryTasksService implements InMemoryDbService{
    createDb(){
      let tasks=[
        {   
        name: "Coder une table HTML",
        deadline: "feb 10 2017",
        pomodorosQty: 1
      },
       {
        name: "Réaliser le croquis de la nouvelle page d'accueil",
        deadline: "jun, 10 2017",
        pomodorosQty: 2
       },
       {
        name: "Styliser la table avec les styles Bootstrap",
        deadline: "may 14 2017",
        pomodorosQty: 1
       },
       {
        name: "Renforcer le SEO avec un sitemap.xml personnalisé",
        deadline: "feb 14 2017",
        pomodorosQty: 3
       }
    ];
    return {tasks};
    }
}