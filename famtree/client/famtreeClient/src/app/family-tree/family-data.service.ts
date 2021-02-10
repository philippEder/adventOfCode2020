import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Human } from './human';

@Injectable({
  providedIn: 'root'
})
export class FamilyDataService {

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
    return this.http.get<Human[]>("http://localhost:4200/api/testdata");
  }


}
