import { HttpClient, HttpHeaders, HttpClientModule, HttpParams ,HttpInterceptor, HttpEvent, HttpHandler, HttpRequest} from '@angular/common/http';
import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
@Injectable({
    providedIn: 'root'
  })
  export class TokenInterceptorService implements HttpInterceptor {
    constructor(private injector:Injector){}

    intercept(req: { clone: (arg0: { setHeaders: { Authorization: string; }; }) => any; }, next: { handle: (arg0: any) => any; }) {
    let tokenizedReq= req.clone({
    
     setHeaders : { 
        Authorization  :'Bearer xx.yy.zz'
    }
   
    
})   

  return next.handle(tokenizedReq)
}



  }