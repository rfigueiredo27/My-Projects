package br.cefetrj.eic.psw.log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Foo {
	Logger logger = null;

	public Foo() {
		logger = LogManager.getLogger(getClass());
		logger.info("Construindo Foo");
	}

	public void testMethod(int x) {
		logger.debug("entrou no teste\tvalor = " + x);
	}

	public static void main(String[] args) {
		Foo foo = new Foo();
		foo.testMethod(5);
	}
}
