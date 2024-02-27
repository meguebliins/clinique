import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { BehaviorSubject, Observable, of } from "rxjs";
import { User } from "../models/user";
import { environment } from "src/environments/environment";
import {
  Auth,
  authState,
  createUserWithEmailAndPassword,
  signInWithEmailAndPassword,
  updateProfile,
  UserInfo,
} from "@angular/fire/auth";

import { concatMap, from, switchMap } from "rxjs";

@Injectable({
  providedIn: 'root'
})

export class AuthService {
  private currentUserSubject: BehaviorSubject<any>;
  public currentUser: Observable<User>;
  private Api = environment.apiNode;

  currentUser$ = authState(this.auth);

  constructor(private http: HttpClient, private auth: Auth) {

    this.currentUserSubject = new BehaviorSubject<User>(
      JSON.parse(localStorage.getItem("currentUser")+"")
    );
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): User {
    return this.currentUserSubject.value;
  }

  ///////////////////   Register
  register(user: User): Observable<string> {
    return this.http.post<string>(`${this.Api}/api/v1/user/register`, user);
  }
    
  signUpFire(email: string, password: string) {
    return from(createUserWithEmailAndPassword(this.auth, email, password));
  }

  ///////////////////// login 
  login(user_email: string, user_password: string): Observable<User> {
    return this.http.post<User>(`${this.Api}/api/v1/user/login`, {
      user_password,
      user_email,
    });
  }

  loginFire(username: string, password: string) {
    return from(signInWithEmailAndPassword(this.auth, username, password));
  }

///////////////////// logOut
  logout() {
    // remove user from local storage to log user out
    localStorage.clear();
    this.currentUserSubject.next(null);
    return of({ success: false });
  }

  logoutFire() {
    return from(this.auth.signOut());
  }

  ///////////////////// autre

  getuserbyId(id: string): Observable<User> {
    return this.http.get<User>(`${this.Api}/api/v1/user/${id}`);
  }

  updateProfileDataFire(profileData: Partial<UserInfo>): Observable<any> {
    const user = this.auth.currentUser;
    return of(user).pipe(
      concatMap((user) => {
        if (!user) throw new Error("Not Authenticated");

        return updateProfile(user, profileData);
      })
    );
  }

 
  getUserbylogin(login: string): Observable<any> {
    return this.http.get<any>(`${this.Api}/api/v1/user/login/${login}`);
  }

}
