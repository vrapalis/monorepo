import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VideoRoomModule } from './plugins/video-room/video-room.module';
import { JanusService } from './janus.service';

@NgModule({
  imports: [CommonModule],
  exports: [VideoRoomModule],
  providers: [JanusService]
})
export class JanusModule {
}
