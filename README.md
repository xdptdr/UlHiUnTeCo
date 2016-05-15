# UlHiUnTeCo

Say Hi to UlHiUnTeCo, The Ul Hibernate Unit Test Collection. The purpose of this project is to embodies  the many intricacies of Hibernate into beautiful self-contained unit tests.

Tests and associated classes are identified by two-letters codes, that appear almost everywhere, from the tests classes to the entities to the table names. This make creating a new unit test from a previous one a bit tedious, but then every unit test is completely isolated from the other with respect to both the database and the Hibernate configuration.

The project contains a small framework for running Hibernate unit tests against HSQL / MySQL or SQLServer. Configuration is usually a matter of setting properties in ulhiunteco.properties. Once all databases have been set up, switching from one to the other only requires changing the type property.

To use the project, follow these steps:

First, in Eclipse, choose File->Import->Projects from Git, and clone this project. URL is https://github.com/xdptdr/UlHiUnTeCo.git

Second, edit ulhiunteco.properties.

Third, if using MySQL or SQLServer, create an empty schema, default name is "ulhiunteco".

Fourth, select one of the unit tests and play with it (usually, Alt+Shift+X J work with the cursor on either the test class or one of the @Tests-annotated test functions).

Fifth, if using MySQL or SQLServer, look inside you database to see the results.

Afterwards, modify anything you want, and don't forget you can always use Replace With->HEAD Revision in the Project Explorer context menu to revert to the original version.

At some point, this project should contains the ultimate way of achieving many things with hibernate. For the moment, the only unit test that could possibly serve as reference is xdptdr.ulhiunteco.ab.TestAB ; that test show how to map a single entity with custom table and column names, and a generated primary key.

But dear unsuspecting user, your curiosity is very welcome. If you notice things that are not being done as they ought to be, you may very well contribute any way you wish, by proposing some new code, or opening an issue.

