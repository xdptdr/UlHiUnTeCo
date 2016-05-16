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

Index of tests:

* AA : Simple Entity with @Entity, @Id, @GeneratedValue
* AB : Same as AA with @Table and @Column
* AC
* AD
* AE
* AF
* AG
* AH
* AI
* AJ
* AK
* AL
* AM
* AN
* AO
* AP
* AQ
* AR
* AS
* AT
* AU
* AV
* AW
* AX
* AY
* [AZ](src/test/java/xdptdr/ulhiunteco/az/TestAZ.java) : Example of 3-ary relationship
  * [ClassroomAZ](src/main/java/xdptdr/ulhiunteco/az/ClassroomAZ.java)
  * [CourseAZ](src/main/java/xdptdr/ulhiunteco/az/CourseAZ.java)
  * [DayAZ](src/main/java/xdptdr/ulhiunteco/az/DayAZ.java)
  * [MeetsAZ](src/main/java/xdptdr/ulhiunteco/az/MeetsAZ.java)
* [BA](src/test/java/xdptdr/ulhiunteco/ba/TestBA.java) : Unconstrained Manager-Subordinate relationshiop with some of the crazy possibilities
  * [EmployeeBA](src/main/java/xdptdr/ulhiunteco/ba/EmployeeBA.java)
  * [ManagesBA](src/main/java/xdptdr/ulhiunteco/ba/ManagesBA.java) 
* [BB](src/test/java/xdptdr/ulhiunteco/bb/TestBB.java) : Exactly the same as BA with OneToOne instead of OneToMany in ManagesBB. Shows that whichever of OneToOne or OneToMany has no effect, but not using any of them does not work.
  * [EmployeeBB](src/main/java/xdptdr/ulhiunteco/bb/EmployeeBB.java)
  * [ManagesBB](src/main/java/xdptdr/ulhiunteco/bb/ManagesBB.java)
* [BC](src/test/java/xdptdr/ulhiunteco/bc/TestBC.java) : Example of an attributed relation ; Strange world in which a same person can be born in different city at different dates
  * [CityBC](src/main/java/xdptdr/ulhiunteco/bc/CityBC.java)
  * [IsBornInBC](src/main/java/xdptdr/ulhiunteco/bc/IsBornInBC.java)
  * [PersonBC](src/main/java/xdptdr/ulhiunteco/bc/PersonBC.java)
* [BD](src/test/java/xdptdr/ulhiunteco/bd/TestBD.java) : Simple linked messages
* [BE](src/test/java/xdptdr/ulhiunteco/be/TestBE.java) : User with private id accessed using session.getIdentifier()
  * [UserBE](src/main/java/xdptdr/ulhiunteco/be/UserBE.java)
* [BF](src/test/java/xdptdr/ulhiunteco/be/TestBF.java) : Difference between annotations on fields and annotations on getters
  * [UserOnGettersBE](src/main/java/xdptdr/ulhiunteco/be/UserOnGettersBE.java)
  * [UserOnFieldsBE](src/main/java/xdptdr/ulhiunteco/be/UserOnFieldsBE.java)
  