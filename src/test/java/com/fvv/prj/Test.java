package com.fvv.prj;

public class Test {

	public static void main(String[] args) {
		String user = System.getProperty("user.name");
		String os = System.getProperty("os.name");
		String osVersion = System.getProperty("os.version");
		String arch = System.getProperty("os.arch");

		System.out.printf("OS User: %s, OS Version: %s %s %s\n", user, os, osVersion, arch);
	}
}