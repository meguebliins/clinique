// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  apiNode : 'http://localhost:8081',
  apiUrl: 'http://localhost:4200',
  firebase: {
    apiKey: "AIzaSyCGRpZFdzIVnlXwj0Wt7clmRH-SCDb54qc",
    authDomain: "chat-4e5b6.firebaseapp.com",
    databaseURL: "https://chat-4e5b6-default-rtdb.firebaseio.com",
    projectId: "chat-4e5b6",
    storageBucket: "chat-4e5b6.appspot.com",
    messagingSenderId: "921666701030",
    appId: "1:921666701030:web:00eeb8a066cfa6c12f5d27"
  }
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
