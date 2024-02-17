package com.examples;

import org.apache.maven.cli.MavenCli;

public class MavenEmbedderRunner {
	public int run(String baseDir, String...args) {
		MavenCli cli = new MavenCli();
		// Required to avoid the error:
		// "-Dmaven.multiModuleProjectDirectory system property is not set."
		System.setProperty("maven.multiModuleProjectDirectory", baseDir);
		return cli.doMain(args, baseDir, System.out, System.err);
	}
}
