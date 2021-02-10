import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { NgxGraphModule } from '@swimlane/ngx-graph';
import { FamilyTreeComponent } from './family-tree/family-tree.component';

@NgModule({
  declarations: [
    AppComponent,
    FamilyTreeComponent
  ],
  imports: [
    BrowserModule,
    NgxGraphModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
