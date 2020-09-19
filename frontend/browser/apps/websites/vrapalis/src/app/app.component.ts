import { Component, OnInit } from '@angular/core';
import { VideoRoomService } from '@browser/janus';
import { Observable } from 'rxjs';
import { IVideoRoom } from '../../../../../libs/janus/src/lib/plugins/video-room/video-room';

@Component({
  selector: 'browser-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  rooms$ = new Observable<Array<IVideoRoom>>();

  constructor(public roomService: VideoRoomService) {
  }

  ngOnInit(): void {
    this.roomService.init().subscribe(plugin => this.rooms$ = this.roomService.getRooms());
  }

  createRoom(value: string) {
    this.roomService.createRoom(value).subscribe(roomId => {
      this.roomService.join(roomId).subsribe();
    });
  }
}
