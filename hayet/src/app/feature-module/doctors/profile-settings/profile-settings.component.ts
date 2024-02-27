import { Component, EventEmitter, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
const noop = () => { };
@Component({
  selector: 'app-profile-settings',
  templateUrl: './profile-settings.component.html',
  styleUrls: ['./profile-settings.component.css']
})
export class ProfileSettingsComponent implements OnInit {
  tags: Array<string> = [];
  tagss: any = [];
  removeLastOnBackspace: boolean = false;
  canDeleteTags: boolean = true;
  onMaxTagsReached: EventEmitter<void> = new EventEmitter();
  private onChangeCallback: (_: any) => void = noop;
  maxTags: any;
  ishidden: boolean = false;
  public educationalArray: any = [{college:'',year:'',degree:''}];
  public experienceArray: any = [{HospitalName:'',From:'',To:'',Designation:''}];
  public awardsArray: any = [{awards:'',year:''}];
  public membershipArray: any = [{membership:''}];
  public registrationArray: any = [{registrations:'',year:''}];
TIMESTAMP = '';
LATITUDE = '';
LONGITUDE = '';
  constructor() { }

  ngOnInit(): void {
  }
  services = [];
  specialization = [];
  files: File[] = [];

  onSelect(event: any) {
    this.files.push(...event.addedFiles);
  }

  onRemove(event: any) {
    this.files.splice(this.files.indexOf(event), 1);
  }
  onTagsChanged(event: any) {
    console.log(event);

  }
  removeLastTag(tagInput: HTMLInputElement): void {
    if (!this.removeLastOnBackspace || !this.tags.length) {
      return;
    }

    if (tagInput.value === '') {
      this.removeTag(this.tags[this.tags.length - 1]);
    }
  }
  removeTag(tagToRemove: any): void {
    if (!this.isDeleteable(tagToRemove)) {
      return;
    }
    this.tags = this.tags.filter((tag: any) => tagToRemove !== tag);
    this.tagsChanged('remove', tagToRemove);
  }
  isDeleteable(tag: any) {
    if (typeof tag.deleteable !== "undefined" && !tag.deleteable) {
      return false;
    }
    return this.canDeleteTags;
  }
  private tagsChanged(type: string, tag: any): void {
    this.onChangeCallback(this.tags);
    // this.onTagsChanged.emit({
    //     change: type,
    //     tag: tag
    // });
    if (this.maximumOfTagsReached()) {
      this.onMaxTagsReached.emit();
    }
  }
  maximumOfTagsReached(): boolean {
    return typeof this.maxTags !== 'undefined' && this.tags && this.tags.length >= this.maxTags;
  }
  public addEducation(): void {
    this.educationalArray.push([{college:'',year:'',degree:''}])
  }
  public deleteEducation(index: any): void {
    this.educationalArray.splice(index,1)
  }
  public addExperience(): void {
    this.experienceArray.push({HospitalName:'',From:'',To:'',Designation:''})
  }
  public deleteExperience(index: any): void {
    this.experienceArray.splice(index, 1)
  }
  public addAwards(): void {
    this.awardsArray.push({awards:'',year:''})
  }
  public deleteAwards(index: any): void {
    this.awardsArray.splice(index, 1)
  }
  public addMemberships(): void {
    this.membershipArray.push({membership:''})
  }
  public deleteMemberships(index: any): void {
    this.membershipArray.splice(index, 1)
  }
  public addRegistrations(): void {
    this.registrationArray.push({registrations:'',year:''})
  }
  public deleteRegistrations(index: any): void {
    this.registrationArray.splice(index, 1)
  }
  pricingOption(event: any) {
    let pricetype = event.target['value']
    if (pricetype == 'price_free') {
      this.ishidden = false
    }
    else (
      this.ishidden = true
    )
  }
  log(){
console.log('service',this.services);
console.log('education',this.educationalArray);
console.log(' specialization ',this.specialization );
console.log('awardsArray',this.awardsArray);
console.log('registrationArray',this.registrationArray);
console.log('membershipArray',this.membershipArray);

  } 

}