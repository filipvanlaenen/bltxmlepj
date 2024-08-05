# Base Library for Typed Extensible Markup Language (XML) Extension Projects in Java (BLTXMLEPJ)

This project aims to provide a base library for the domain-specific languages
(DSL) to create files for XML (Extensible Markup Language) extensions in Java in
an easy way, with all the advantages of typing.

## Getting Started

First of all, you need to obtain a copy of the source code, complile it and
install it locally. Run the following commands to do this:

```
git clone git@github.com:filipvanlaenen/bltxmlepj.git
cd bltxmlepj
mvn clean install
```

*Note: If requested by enough people, this library can be deployed to a central
Maven repository ([Issue #1](https://github.com/filipvanlaenen/bltxmlepj/issues/1)).*

If everything works well, you'll be able to use the BLTXMLEPJ library in another
Java project by adding the following dependency in the project's POM file:

```xml
  <dependency>
    <groupId>net.filipvanlaenen</groupId>
    <artifactId>bltxmlepj</artifactId>
    <version>1.0.0</version>
  </dependency>
```

Be sure to update to the appropriate version number.

## Projects Using BLTXMLEPJ

The following projects use BLTXMLEPJ:
* [TSVGJ](https://github.com/filipvanlaenen/tsvgj)
* [TXHTMLJ](https://github.com/filipvanlaenen/txhtmlj)
