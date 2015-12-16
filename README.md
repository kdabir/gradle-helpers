# Gradle Helpers

[![Build Status](https://travis-ci.org/kdabir/gradle-helpers.svg?branch=master)](https://travis-ci.org/kdabir/gradle-helpers)

Exposes utility methods under `helpers` namespace. Does not touch any other part of build.


## Usage

Apply the plugin to the project

    plugins {
        id "io.github.kdabir.gradle-helpers" version "0.0.3"
    }

Get helper methods in your build script

## Methods

- <code>java.lang.Object <strong>createSourceDirs</strong>()</code>
    Creates all the sourceSets directories

- <code>java.util.List&lt;java.io.File&gt; <strong>getSourceDirs</strong>()</code>
    Returns all configured source directories

- <code>java.util.Properties <strong>loadProperties</strong>(java.lang.String filename)</code>
    Loads properties from file path relative to project root

- <code>java.util.Properties <strong>loadProperties</strong>(java.io.File file)</code>
    Loads properties from given file object

- <code>java.util.List&lt;java.lang.String&gt; <strong>methodsOf</strong>(java.lang.Object obj)</code>
    Lists available methods on an object
