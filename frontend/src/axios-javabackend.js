import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://techchallenge-env.eba-2ksyirsk.us-west-2.elasticbeanstalk.com/api/'
});

export default instance;