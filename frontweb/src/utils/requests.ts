import axios from 'axios';
import qs from 'qs';

export const BASE_URL = 'http://localhost:8080';

const CLIENT_ID = 'dsdelivery';
const CLIENT_SECRET = 'dsdelivery123';

type LoginData = {
  username: string;
  password: string;
};

export const requestBackendLogin = (loginData: LoginData) => {
  const headers = {
    'Content-Type': 'application/x-www-form-urlencoded',
    Authorization: 'Basic ' + window.btoa(CLIENT_ID + ':' + CLIENT_SECRET),
  };

  const data = qs.stringify({
    ...loginData,
    grant_type: 'password',
  });

  return axios({method: 'POST', baseURL: BASE_URL, url: '/oauth/token', data, headers});

};
