import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FeatureModuleModule } from './feature-module/feature-module.module';
import { SharedModule } from './shared/module/shared.module';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import { getAuth } from "firebase/auth";
import { Auth, provideAuth } from "@angular/fire/auth";
import { provideFirestore } from "@angular/fire/firestore";
import { getFirestore } from "firebase/firestore";
import { getStorage, provideStorage } from '@angular/fire/storage';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FeatureModuleModule,
    SharedModule,
    HttpClientModule,
 
    
  ],
  providers: [ { provide: LocationStrategy, useClass: HashLocationStrategy},
   
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
