package aula13.reflection;

import aula13.IPlugin;

public class PluginString implements IPlugin {

	@Override
	public void fazQualQuerCoisa() {
		System.out.println("Este é o \nPluginString!");		
	}
}
