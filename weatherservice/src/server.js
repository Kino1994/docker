const grpc = require('grpc');
const WeatherService = require('./interface');
const weatherServiceImpl = require('./weatherService');

const server = new grpc.Server();

server.addService(WeatherService.service, weatherServiceImpl);

const endpoint = `${process.env.WEATHER_HOST}:${process.env.WEATHER_PORT}`;

server.bind(endpoint, grpc.ServerCredentials.createInsecure());

console.log('gRPC server running at http://127.0.0.1:9090');

server.start();
