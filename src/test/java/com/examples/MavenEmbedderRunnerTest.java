package com.examples;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

public class MavenEmbedderRunnerTest {

	private MavenEmbedderRunner runner;

	@Before
	public void setup() {
		runner = new MavenEmbedderRunner();
	}

	@Test
	public void testRunnerOnSimpleProject() {
		String baseDir = new File("target/test-classes/maven-quickstart-example").getAbsolutePath();
		assertEquals(0, runner.run(baseDir, "clean", "verify"));
	}

	@Test
	public void testRunnerWithLocalRepo() throws IOException {
		File localRepo = new File("target/test-classes/local-repo");
		FileUtils.deleteDirectory(localRepo);
		String baseDir = new File("target/test-classes/maven-quickstart-example").getAbsolutePath();
		assertEquals(0, runner.run(baseDir, "-Dmaven.repo.local=" + localRepo.getAbsolutePath(), "clean", "verify"));
	}
}
