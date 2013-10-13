package com.inmobi.psoapp370.test;

import java.net.URLClassLoader;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import android.test.ActivityInstrumentationTestCase2;

import com.inmobi.app.sdk362.InMobiAdActivity362;

//ActivityInstrumentationTestCase2<InMobiAdActivity362>
public class SeparateClassloaderTestRunner extends BlockJUnit4ClassRunner {

    public SeparateClassloaderTestRunner(Class<?> clazz) throws InitializationError {
        super(getFromTestClassloader(clazz));
    }

    private static Class<?> getFromTestClassloader(Class<?> clazz) throws InitializationError {
        try {
            TestClassLoader testClassLoader = new TestClassLoader();
            return Class.forName(clazz.getName(), true, testClassLoader);
        } catch (ClassNotFoundException e) {
            throw new InitializationError(e);
        }
    }

    public static class TestClassLoader extends URLClassLoader {
        public TestClassLoader() {
            super(((URLClassLoader)getSystemClassLoader()).getURLs());
        }

        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.startsWith("com.inmobi.psoapp370.test.")) {
                return super.findClass(name);
            }
            return super.loadClass(name);
        }
    }	
    
	public static void main(String[] args) {

	}
}


