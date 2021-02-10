import { Component, Inject, OnInit } from '@angular/core';
import { FamilyDataService } from './family-data.service';

@Component({
  selector: 'app-family-tree',
  templateUrl: './family-tree.component.html',
  styleUrls: ['./family-tree.component.css']
})
export class FamilyTreeComponent{

  nodes = [];
  links = [];


  constructor(private familyDataService: FamilyDataService) {
    familyDataService.getNodes().subscribe(humans => {
      humans.forEach(human => console.log(human));
    });
    this.nodes = familyDataService.getTestNodes();
    this.links = familyDataService.getTestLinks();
  }


}
