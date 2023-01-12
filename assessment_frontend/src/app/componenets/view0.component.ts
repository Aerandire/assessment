import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { UploadService } from '../service/upload.service';

@Component({
  selector: 'app-view0',
  templateUrl: './view0.component.html',
  styleUrls: ['./view0.component.css']
})
export class View0Component implements OnInit {

  @ViewChild('imageFile') imageFile!: ElementRef;
  path = [ '' ]
  form!: FormGroup

  constructor(private fb: FormBuilder, private router: Router, private uploadSvc: UploadService,private http: HttpClient) {
  }

  ngOnInit(): void {
    this.form = this.createForm()
  }

  private createForm(): FormGroup {
    return this.fb.group({
      name: this.fb.control<string>('',[Validators.required, Validators.minLength(3)]),
      email: this.fb.control<string>('', [Validators.required, Validators.email, Validators.maxLength(128)]),
      phone: this.fb.control<string>('', [Validators.required]),
      title: this.fb.control<string>('', [Validators.required, Validators.minLength(5), Validators.maxLength(128)]),
      description: this.fb.control<string>('',[Validators.required]),
      image: this.fb.control<any>('',[Validators.required]),
    })
  }

  processForm() {
    const data = this.form.value
    const email = this.form.controls['email'].value
    console.info(">>>>>>Data:", data)

    const formData = new FormData();
    formData.append('name', this.form.controls['name'].value);
    formData.append('email', this.form.controls['email'].value);
    formData.append('phone', this.form.controls['phone'].value);
    formData.append('title', this.form.controls['title'].value);
    formData.append('description', this.form.controls['description'].value);
    formData.set('image', this.imageFile.nativeElement.files[0]);

    this.uploadSvc.postListing(formData)
      .then(result=> {
        console.info(result)
        this.router.navigate(['/view1'])
      })
  }

  clearForm(){
    this.form.reset();
  }

}
