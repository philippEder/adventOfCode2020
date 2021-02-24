import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Human } from './human';
import { Node } from '../dto/node'
import { Link } from '../dto/link'

@Injectable({
  providedIn: 'root'
})
export class FamilyDataService {


  nodes : Node[]
  links : Link[]


  testDataNodes = [
         {
           id: 'ie',
           label: 'Irmgard Eder'
         },
         {
           id: 'ak',
           label: 'Alexandra Kussberger'
         },
         {
           id: 'me',
           label: 'Michaela Eder'
         }
  ]

  testDataLinks = [
         {
           id: 'a',
           source: 'ie',
           target: 'ak',
           label: 'is parent of'
         },
         {
           id: 'b',
           source: 'ie',
           target: 'me',
           label: 'is parent of'
         }
  ]

  constructor(private http: HttpClient) { }

  getTestNodes() {
    return this.testDataNodes;
  }

  getTestLinks() {
      return this.testDataLinks;
  }

  getNodes() : Observable<Human[]> {
    return this.http.get<Human[]>("http://localhost:4200/api/treedata");
  }


  getNodes1() : Node[] {
    this.nodes = [];
    this.links = [];
    this.http.get<Human[]>("http://localhost:4200/api/treedata").subscribe(humans => {

      var currenHumans = humans;

      while (currenHumans.length > 0) {
        humans.forEach(human => {
          this.nodes.push(new Node(human.name, human.name));
          human.children.forEach(child => {
              this.links.push(new Link(child.name, human.name, child.name, 'parent of'));
          })
          currenHumans = human.children;
      }) 
      }
    })

    return this.nodes;
  }

}
