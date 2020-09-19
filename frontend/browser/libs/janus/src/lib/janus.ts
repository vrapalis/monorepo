import { JanusJS } from 'janus-gateway/npm';

export interface IJanusPluginMessage extends JanusJS.PluginMessage{
  message: {
    request: string;
    [otherProps: string]: any;
  };
  success?: Function;
  jsep?: JanusJS.JSEP;
}

export interface IJanusPlugin extends  JanusJS.PluginHandle {
  send(message: IJanusPluginMessage): void;
}
