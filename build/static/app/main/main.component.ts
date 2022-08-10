import {Component, Inject, OnInit} from '@angular/core';
import {DownloadfileService} from "../downloadfile.service";
import {ConfigService} from "../config.service";
import {FormControl, FormGroup} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialog} from "@angular/material/dialog";

export interface DialogData {
  animal: 'panda' | 'unicorn' | 'lion';
}

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['css/aos.css', 'css/bootstrap.min.css', 'css/main.css',]
})
export class MainComponent implements OnInit {
  constructor(private download: DownloadfileService, private http: ConfigService,
              public dialog:MatDialog
              ) {}
  path: string = "./images/anthony.jpg";
  alttext: string = "first image"
  error: any;
  message: string | undefined
  form = new FormGroup({
    email: new FormControl(),
    message: new FormControl(),
    subject: new FormControl(),
    name: new FormControl()
  })




  ngOnInit(): void {
  }

  openDialog() {
    this.dialog.open(DialogDataExampleDialog, {
      data: {
        animal: 'panda',
      },
    });
  }

  contactMe() {
    this.http.postContact(this.form.value)
      .subscribe(res => this.message =res, error => this.error = error)
    this.form.reset({email: '', name: '', subject: '', message: ''})
    this.openDialog();

  }
}

@Component({
  selector: 'dialog-data-example-dialog',
  templateUrl: 'dialog-data-example-dialog.html',
})
export class DialogDataExampleDialog {
  constructor(@Inject(MAT_DIALOG_DATA) public data: DialogData) {}
}
