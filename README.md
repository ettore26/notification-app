# Notification App

A Clojure-based notification service that provides a REST API for sending notifications across multiple channels (Email, SMS, Push) with category-based filtering (Sports, Finance, Movies). Built with Ring/Compojure for the backend and ClojureScript for the frontend.

## Installation

Download from https://github.com/app/core

## Usage

### For Release

Build and run uberjar:

    $ clojure -T:build uberjar
    $ java -jar target/net.clojars.app/core-0.1.0-SNAPSHOT.jar

### For Dev and Other

Run the project, overriding the name to be greeted:

    $ clojure -X:run-x :name '"Someone"'
    Hello, Someone!

Run the project directly, via `:main-opts` (`-m app.core`):

    $ clojure -M:run

Run the project's tests (they'll fail until you edit them):

    $ clojure -T:build test

Build an uberjar:

    $ clojure -T:build uberjar

Run the project's CI pipeline and build an uberjar (this will fail until you edit the tests to pass):

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

