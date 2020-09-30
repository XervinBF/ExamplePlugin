package org.xbf.addons.example;

import java.awt.Color;

import org.xbf.core.XBF;
import org.xbf.core.XVI;
import org.xbf.core.Messages.Response;
import org.xbf.core.Messages.RichResponse;
import org.xbf.core.Plugins.DependsOn;
import org.xbf.core.Plugins.PluginVersion;
import org.xbf.core.Plugins.XPlugin;
import org.xbf.core.Plugins.XervinJavaPlugin;

@XPlugin(name="exampleplugin", displayname="XBF ExamplePlugin", description="An ExamplePlugin for XBF")
@PluginVersion(currentVersion="1.0.0")
@DependsOn(pluginName="xbf", minimumVersion="0.0.9")
public class ExamplePlugin extends XervinJavaPlugin {

	@Override
	public void register() {
		XBF.registerModule("TestModule").registerCommand("test", (args, req) -> {
			return new Response(req).addRichResponse(new RichResponse("Hello World!")
					.setDescription("It works!")
					.addField(XBF.BOT_FRAMEWORK_NAME + " Version", XVI.version.getVersionString())
					.addCommand("Call command again!", "test")
					.setColor(Color.LIGHT_GRAY)
					.setFooter(XBF.BOT_FRAMEWORK_NAME + " - Example Plugin"));
		});
	}
	
}
