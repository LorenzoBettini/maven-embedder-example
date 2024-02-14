package com.examples;

import org.apache.maven.cli.MavenCli;

public class MavenEmbedderRunner {
	public void run(String baseDir, String...args) {
		MavenCli cli = new MavenCli();
		cli.doMain(args, baseDir, System.out, System.err);
	}
}
