# Mental and technical reasons for upgrading Java from 8 to 14

Recently, I was telling fellow software engineers what technology stack I was working on, indicating that this was the latest Java 14 (Java Platform, SE) and the latest Spring Boot 2.4. One of them asked me about the reasons why I would recommend switching from 8 to 14. When, shortly thereafter, I returned to this question, I felt a need to speak in writing.
As of today, I would classify the reasons for the upgrade into two groups. The first is less obvious, relative, mental, depends on the circumstances and view on the software development and its life cycle. The second is purely technical, quite objective, and I will focus on this one mainly in this post.

---

List of technical reasons chronologically

JDK 9
- Stream interface methods
- Private methods in interfaces
- Factory methods for collections
- G1 as a default garbage collector
- Older version compilation
- jlink
 
JDK 10
- Improvements for Docker containers
- Local variables type inference
- Parallel full GC in G1

JDK 11
- API changes

JDK 12
- G1 with automatic memory shrinking

JDK 13 (just a note)

JDK 14
- Verbose NPE messages
- Switch Expressions

---

First, a bit (more precisely, around 7k bits) of history.

Since September 2017, Java has become agile and choose Scrum. Since then, the Java family in six-month sprints provides us with further increments in the form of subsequent JDK versions, starting from version 9.
Currently, the latest JDK General Availability release is version 14, released in March this year.

Earlier Java years, childhood and adolescence, were the same as times in which these early years were. In my opinion, the domination times of “ENTERPRISE-CLASS” systems, fixed hardware, fixed JDK version, fixed application server version, and etc. In these times, changes or reacting to changes were often perceived as a threat than an advantage or resilience.

Arithmetically averaging, including version 9, subsequent Java versions appeared on average every 26 months, i.e. that’s over two years. Java’s longest winter sleep period was between Java SE 6 and 7 and lasted over 4 years and 7 months.

---

From version 8 to version 14, 149 JEPs (JDK Enhancement Proposals) have been processed. JDK 9 brought 91 JEPs and was a game-changer that opened a new period in the continuous Java development.

As it stands, it is much easier for engineers to keep up to date with Java news. Instead of reading a thick book every few years, we just need a couple of evenings, every half a year, to familiarize and learn new stuff. In the dynamics of everyday work, it is easier to find time for relatively small increments and easier to approach and pursue continuous development.

Before moving to specific technical aspects of the individual release, it should be pointed out that Oracle does not, any longer, provide free support for commercial JDK 8 use. Further updates require a commercial license.

"Java SE 8 has gone through the End of Public Updates process for legacy releases. Oracle will continue to provide free public updates and auto updates of Java SE 8 indefinitely for Personal, Development and other Users via java.com."
