FROM node:latest AS node

WORKDIR /code

COPY package.json .

RUN npm set progress=false && \
    npm config set depth 0 && \
    npm install --only=production

# ------------------------------------------------------------------------------

FROM babashka/babashka AS BB

WORKDIR /code

RUN curl -LO https://github.com/retrogradeorbit/bootleg/releases/download/v0.1.9/bootleg-0.1.9-linux-amd64.tgz && \
    tar xvf bootleg-0.1.9-linux-amd64.tgz && \
    mv bootleg /usr/bin/

COPY . .

RUN bb site.clj

# ------------------------------------------------------------------------------

FROM nginx:alpine

WORKDIR /usr/share/nginx/html

COPY --from=BB /code .
COPY --from=node /code/node_modules ./node_modules