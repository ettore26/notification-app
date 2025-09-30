# Notification App

A Clojure-based notification service that provides a REST API for sending notifications across multiple channels (Email, SMS, Push) with category-based filtering (Sports, Finance, Movies). Built with Ring/Compojure for the backend and ClojureScript for the frontend.

## Usage

### For Release

Build and run uberjar:

    $ clojure -T:build uberjar
    $ java -jar target/net.clojars.app/core-0.1.0-SNAPSHOT.jar

### For Dev and Other

Run the project CLJS directly:

    $ npx shadow-cljs watch app

Run the project CLJ directly:

    $ clojure -M:run

Run the project's tests:

    $ clojure -T:build test

Build an uberjar:

    $ clojure -T:build uberjar

Run the project's CI pipeline and build an uberjar:

    $ clojure -T:build ci

## TODO

- [x] Basic REST API structure
- [x] Category filtering (Sports, Finance, Movies)
- [x] Channel routing (SMS, Email, Push)
- [x] Frontend interface
- [x] Uberjar build configuration
- [ ] Tests
- [ ] Email service integration
- [ ] SMS service integration
- [ ] Push notification service integration

