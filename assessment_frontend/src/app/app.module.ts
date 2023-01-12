import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { UploadService } from './service/upload.service';

import { AppComponent } from './app.component';
import { View0Component } from './componenets/view0.component';
import { View1Component } from './componenets/view1.component';
import { View2Component } from './componenets/view2.component';

const appPath: Routes = [
  { path: '', component: View0Component },
  { path: 'view1', component: View1Component},
  { path: 'view2', component: View2Component},
  { path: '**', redirectTo: '/', pathMatch: 'full' }
]

@NgModule({
  declarations: [
    AppComponent,
    View0Component,
    View1Component,
    View2Component
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appPath),
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [ UploadService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
