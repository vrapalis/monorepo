export interface IVideoRoom {
  audiocodec: string;
  audiolevel_event: boolean;
  audiolevel_ext: boolean;
  bitrate: number;
  description: string;
  fir_freq: number;
  lock_record: boolean;
  max_publishers: number;
  notify_joining: boolean;
  num_participants: number;
  pin_required: boolean;
  playoutdelay_ext: boolean;
  record: boolean;
  require_e2ee: boolean;
  require_pvtid: boolean;
  room: number;
  transport_wide_cc_ext: boolean;
  video_svc: boolean;
  videocodec: string;
  videoorient_ext: boolean;
}
