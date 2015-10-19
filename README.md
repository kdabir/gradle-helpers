# Gradle Helpers

[![Build Status](https://travis-ci.org/kdabir/gradle-helpers.svg?branch=master)](https://travis-ci.org/kdabir/gradle-helpers)

Exposes utility methods under `helpers` namespace. Does not touch any other part of build.

## Methods


`helpers.loadProperties(filename)`

loads properties from relative to project root

`helpers.loadProperties(fileObj)`

loads properties from file

`helpers.methodsOf(anyObject)`

lists available methods on an object
