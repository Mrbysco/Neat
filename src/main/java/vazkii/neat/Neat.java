package vazkii.neat;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.IExtensionPoint.DisplayTest;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkConstants;

@Mod(Neat.MOD_ID)
public class Neat {

	public static final String MOD_ID = "neat";

	public Neat() {
		ModLoadingContext.get().registerExtensionPoint(DisplayTest.class,()-> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		NeatConfig.init();
	}

	public void setup(FMLClientSetupEvent event) {
		NeatConfig.load();

		MinecraftForge.EVENT_BUS.register(new ToggleKeybind());
		MinecraftForge.EVENT_BUS.register(new HealthBarRenderer());
	}
}
