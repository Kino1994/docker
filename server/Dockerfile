FROM node:14.16.0-alpine3.10 as builder
WORKDIR /usr/app/
COPY package.json /usr/app
RUN npm install --only=production



FROM node:14.16.0-alpine3.10
ENV NODE_ENV production
WORKDIR /usr/app/
RUN apk add curl && curl -LJO https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh && chmod +x /usr/app/wait-for-it.sh
COPY --from=builder /usr/app/node_modules /usr/app/node_modules
COPY /src /usr/app/src
EXPOSE 5000
ENTRYPOINT ["node"]
CMD ["src/server.js"]
