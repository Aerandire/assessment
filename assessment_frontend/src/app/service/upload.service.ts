import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom } from "rxjs";

@Injectable()
export class UploadService {

  constructor(private http: HttpClient) { }

  upload(file: File | Blob) {
    const data = new FormData()
    data.set('myfile', file)
    return firstValueFrom(
      this.http.post<any>('/upload/spaces', data)
    )
  }

  postListing(formData: FormData) {
    return firstValueFrom(
        this.http.post<FormData>('api/posting', formData)
    )
  }
}