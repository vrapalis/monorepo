import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { JanusService } from './janus.service';

@NgModule({
  imports: [CommonModule],
  providers: [JanusService]
})
export class JanusModule {
}
