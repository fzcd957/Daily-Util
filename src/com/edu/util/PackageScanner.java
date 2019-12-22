package com.edu.util;

import java.io.File;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
//包扫描
public abstract class PackageScanner {
	
	public PackageScanner() {
	}

	public abstract void dealClass(Class<?> klass);
	
	private void scannerDirectory(File currentFile, String packageName) {
		if (!currentFile.isDirectory()) {
			return;
		}
		File[] files = currentFile.listFiles();
		for (File file : files) {
			if (file.isFile() && file.getName().endsWith(".class")) {
				String fileName = file.getName().replace(".class", "");
				String className = packageName + "." + fileName;
				try {
					Class<?> klass = Class.forName(className);
					dealClass(klass);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} else if (file.isDirectory()) {
				scannerDirectory(file, packageName + "." + file.getName());
			}
		}
	}
	
	private void scannerJar(URL url) {
		try {
			JarURLConnection urlConnection = (JarURLConnection) url.openConnection();
			JarFile jarFile = urlConnection.getJarFile();
			Enumeration<JarEntry> jarEntries = jarFile.entries();
			while (jarEntries.hasMoreElements()) {
				JarEntry jarEntry = jarEntries.nextElement();
				String name = jarEntry.getName();
				if (jarEntry.isDirectory() || !name.endsWith(".class")) {
					continue;
				}
				name = name.replace(".class", "");
				String className = name.replace('/', '.');
				Class<?> klass = Class.forName(className);
				dealClass(klass);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void scannerPackage(String packageName) {
		String packagePath = packageName.replace('.', '/');
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			Enumeration<URL> resources = classLoader.getResources(packagePath);
			while (resources.hasMoreElements()) {
				URL url = resources.nextElement();
				if (url.getProtocol().equals("jar")) {
					scannerJar(url);
				} else { // 按普通包扫描
					File root = new File(url.toURI());
					scannerDirectory(root, packageName);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}