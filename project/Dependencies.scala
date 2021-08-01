import sbt._

object Dependencies {
  lazy val differentialprivacy = "com.google.privacy" % "differentialprivacy" % "1.0.0"
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.8"
}


/*

<dependencies>
<dependency>
  <groupId>com.google.auto.value</groupId>
  <artifactId>auto-value</artifactId>
  <version>1.7.5</version>
</dependency>
<dependency>
  <groupId>com.google.auto.value</groupId>
  <artifactId>auto-value-annotations</artifactId>
  <version>1.7.5</version>
</dependency>
<dependency>
  <groupId>com.google.code.findbugs</groupId>
  <artifactId>jsr305</artifactId>
  <version>3.0.2</version>
</dependency>
<dependency>
  <groupId>com.google.errorprone</groupId>
  <artifactId>error_prone_annotations</artifactId>
  <version>2.5.1</version>
</dependency>
<dependency>
  <groupId>com.google.guava</groupId>
  <artifactId>guava</artifactId>
  <version>30.1.1-jre</version>
</dependency>
<dependency>
  <groupId>com.google.protobuf</groupId>
  <artifactId>protobuf-java</artifactId>
  <version>3.15.6</version>
</dependency>
<dependency>
  <groupId>org.apache.commons</groupId>
  <artifactId>commons-math3</artifactId>
  <version>3.6.1</version>
</dependency>
</dependencies>

*/