FROM node:lts-alpine as builder
WORKDIR /usr/app/
COPY package.json /usr/app/
RUN npm install --only=production


FROM node:lts-alpine
ENV NODE_ENV production
WORKDIR /usr/app/
RUN apk add curl && apk add bash
RUN curl -LJO https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh && chmod +x /usr/app/wait-for-it.sh
COPY --from=builder /usr/app/node_modules /usr/app/node_modules
COPY --from=builder /usr/app/package.json /usr/app/
COPY config /usr/app/config
COPY src /usr/app/src
EXPOSE 3000
ENTRYPOINT ["node"]
CMD ["src/server.js"]
