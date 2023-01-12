import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { UploadService } from './service/upload.service';

import { AppComponent } from './app.component';
import { View0Component } from './componenets/view0.component';

const appPath: Routes = [
  { path: '', component: View0Component },
  { path: '**', redirectTo: '/', pathMatch: 'full' }
]

@NgModule({
  declarations: [
    AppComponent,
    View0Component
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
